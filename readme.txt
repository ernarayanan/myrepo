The design of the code goes like this:

1. Used Page Object Model to have the pages in the framework
2. The input part is controlled from testng.xml. I have not used any external file as input here.
3. To run the test, find the file testng_shareByEmail.xml. Right click and run as TestNG. In eclipse, we need to have testng plugin integrated
4. I have  used the Java Mail API to read from the GMAIL instead of launching the UI Part of the gmail. Because, our test scope is to verify the shared details 
5. Assertion has been used here just to verify the text from email and the link. One more step can be done. Launch the URL from the email and verify something on the page.

Due to time constraint, i have done little. Please check out the class path file so that the libraries are  in the class path.

