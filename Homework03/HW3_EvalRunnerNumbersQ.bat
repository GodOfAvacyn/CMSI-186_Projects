@echo off
@del testresults.txt
@javac *.java

@echo *** >> testresults.txt
@echo Starting DieAndDiceSetTestHarness run >> testresults.txt
@echo *** >> testresults.txt
@java DieAndDiceSetTestHarness > testresults.txt
@echo *** >> testresults.txt
@echo Finished DieAndDiceSetTestHarness run >> testresults.txt
@echo *** >> testresults.txt

@echo *** >> testresults.txt
@echo Starting HighRoll 5 6 run >> testresults.txt
@echo *** >> testresults.txt
@java HighRoll 5 6 < numInput1Q.txt >> testresults.txt
@echo *** >> testresults.txt
@echo Finished HighRoll 5 6 run >> testresults.txt
@echo *** >> testresults.txt

@echo *** >> testresults.txt
@echo Starting HighRoll 11 17 run >> testresults.txt
@echo *** >> testresults.txt
@java HighRoll 11 17 < numInput2Q.txt >> testresults.txt
@echo *** >> testresults.txt
@echo Finished HighRoll 11 17 run >> testresults.txt
@echo *** >> testresults.txt

@echo *** >> testresults.txt
@echo Starting HighRoll 29 4 run >> testresults.txt
@echo *** >> testresults.txt
@java HighRoll 29 4 < numInput3Q.txt >> testresults.txt
@echo *** >> testresults.txt
@echo Finished HighRoll 29 4 run >> testresults.txt
@echo *** >> testresults.txt

@echo *** >> testresults.txt
@echo Starting HighRoll 3 3 error check run >> testresults.txt
@echo *** >> testresults.txt
@java HighRoll 3 3 >> testresults.txt
@echo *** >> testresults.txt
@echo Finished HighRoll 3 3 error check run >> testresults.txt
@echo *** >> testresults.txt

