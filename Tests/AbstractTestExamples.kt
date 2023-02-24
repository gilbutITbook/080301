import atomictest.ERROR_TAG
import org.junit.jupiter.api.Assertions.*
import org.junit.platform.engine.discovery.DiscoverySelectors.selectClass
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder
import org.junit.platform.launcher.core.LauncherFactory
import org.junit.platform.launcher.listeners.SummaryGeneratingListener
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.PrintStream
import java.util.function.Consumer


abstract class AbstractTestExamples {


  protected fun testJUnitClass(testClass: Class<*>) {
    val request =
      LauncherDiscoveryRequestBuilder.request()
        .selectors(selectClass(testClass))
        .build()
    //val plan = LauncherFactory.create().discover(request)
    val launcher = LauncherFactory.create()
    val summaryListener = SummaryGeneratingListener()
    launcher.execute(request, summaryListener)
    assertTrue(summaryListener.summary.totalFailureCount == 0L)
  }

  protected fun testExample(fileName: String, main: Runnable) {
    testExample(fileName, Consumer { main.run() })
  }

  protected fun testExample(fileName: String, main: Consumer<Array<String>>) {
    val exampleCode = File(fileName).readText()
    val outputComment = "/* Output:"
    if (exampleCode.contains(outputComment)) {
      val output = extractOutput(exampleCode, outputComment)
      testOutput(output, main, trim = true)
    }
    val inputOutputComment = "/* Input/Output:"
    if (exampleCode.contains(inputOutputComment)) {
      val inputAndOutput = extractOutput(exampleCode, inputOutputComment)
      testInputOutput(inputAndOutput, main)
    } else {
      testNoErrors(main)
    }
  }

  private fun extractOutput(exampleCode: String, outputComment: String) =
    exampleCode.substringAfter(outputComment).substringBefore("*/").trim()

  private fun testOutput(output: String, main: Consumer<Array<String>>, trim: Boolean) {
    val result = runAndGetOutput(main).let {
      if (trim) it.trim() else it
    }
    assertEquals(result.normalizeLineSeparators(), output.normalizeLineSeparators())
  }

  private fun runAndGetOutput(main: Consumer<Array<String>>): String {
    val out = ByteArrayOutputStream()
    System.setOut(PrintStream(out))

    main.accept(arrayOf())

    return out.toString()
  }

  private fun testInputOutput(inputAndOutput: String, main: Consumer<Array<String>>) {
    val (inputLines, outputLines) = inputAndOutput.lines().partition { it.startsWith(">>>") }
    val input = inputLines.joinToString(LINE_SEPARATOR) { it.substringAfter(">>> ") }
    val output = outputLines.joinToString(LINE_SEPARATOR)

    val inputStream = ByteArrayInputStream(input.toByteArray())
    System.setIn(inputStream)

    val out = ByteArrayOutputStream()
    System.setOut(PrintStream(out))

    main.accept(arrayOf())

    assertEquals(out.toString().trim().normalizeLineSeparators(), output.normalizeLineSeparators())
  }

  private fun testNoErrors(main: Consumer<Array<String>>) {
    val output = runAndGetOutput(main)
    assertFalse(output.contains(ERROR_TAG), "Program completed with errors:\n$output")
  }
}

private val LINE_SEPARATOR: String = System.getProperty("line.separator")

private fun String.normalizeLineSeparators(): String {
  return replace("\\R".toRegex(), LINE_SEPARATOR)
}
