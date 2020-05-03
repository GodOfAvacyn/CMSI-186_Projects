@del TestResults.txt
@del CircleSolver.class
@rmdir /Q /S docs

@mkdir docs
@javadoc -d docs CircleSolver.java
@javac CircleSolver.java

@echo Creating Testresults file...
echo Test Results >> TestResults.txt
@echo Testing our circles...
echo Testing files 1 - 20 with CircleSolver... >> TestResults.txt
java CircleSolver CircleDefinition/test1.txt >> TestResults.txt
echo . >> TestResults.txt
java CircleSolver CircleDefinition/test2.txt >> TestResults.txt
echo . >> TestResults.txt
java CircleSolver CircleDefinition/test3.txt >> TestResults.txt
echo . >> TestResults.txt
java CircleSolver CircleDefinition/test4.txt >> TestResults.txt
echo . >> TestResults.txt
java CircleSolver CircleDefinition/test5.txt >> TestResults.txt
echo . >> TestResults.txt
java CircleSolver CircleDefinition/test6.txt >> TestResults.txt
echo . >> TestResults.txt
java CircleSolver CircleDefinition/test7.txt >> TestResults.txt
echo . >> TestResults.txt
java CircleSolver CircleDefinition/test8.txt >> TestResults.txt
echo . >> TestResults.txt
java CircleSolver CircleDefinition/test9.txt >> TestResults.txt
echo . >> TestResults.txt
java CircleSolver CircleDefinition/test10.txt >> TestResults.txt
echo . >> TestResults.txt
java CircleSolver CircleDefinition/test11.txt >> TestResults.txt
echo . >> TestResults.txt
java CircleSolver CircleDefinition/test12.txt >> TestResults.txt
echo . >> TestResults.txt
java CircleSolver CircleDefinition/test13.txt >> TestResults.txt
echo . >> TestResults.txt
java CircleSolver CircleDefinition/test14.txt >> TestResults.txt
echo . >> TestResults.txt
java CircleSolver CircleDefinition/test15.txt >> TestResults.txt
echo . >> TestResults.txt
java CircleSolver CircleDefinition/test16.txt >> TestResults.txt
echo . >> TestResults.txt
java CircleSolver CircleDefinition/test17.txt >> TestResults.txt
echo . >> TestResults.txt
java CircleSolver CircleDefinition/test18.txt >> TestResults.txt
echo . >> TestResults.txt
java CircleSolver CircleDefinition/test19.txt >> TestResults.txt
echo . >> TestResults.txt
java CircleSolver CircleDefinition/test20.txt >> TestResults.txt