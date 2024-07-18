import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import groovy.json.JsonSlurper as JsonSlurper

def jsonSlurper = new JsonSlurper()

//Recuperar token SalesForce
ResponseObject responseTokenSF = WS.sendRequest(findTestObject('Postman/token/Token_SF_QA'))

WS.verifyResponseStatusCode(responseTokenSF, 200)

def jsonResponseTokenSF = jsonSlurper.parseText(responseTokenSF.getResponseText())

GlobalVariable.TOKEN = ('Bearer ' + jsonResponseTokenSF.access_token)

print(GlobalVariable.TOKEN)

KeywordUtil.logInfo('Token: ' + GlobalVariable.TOKEN)

//Recuperar token Openshift
ResponseObject responseTokenOpenshift = WS.sendRequest(findTestObject('Postman/token/QA - Generación Token Institucional'))

WS.verifyResponseStatusCode(responseTokenOpenshift, 200)

def jsonResponseTokenOpenshift = jsonSlurper.parseText(responseTokenOpenshift.getResponseText())

GlobalVariable.TOKEN_INSTITU = ('Bearer ' + jsonResponseTokenOpenshift.access_token)

print(GlobalVariable.TOKEN_INSTITU)



