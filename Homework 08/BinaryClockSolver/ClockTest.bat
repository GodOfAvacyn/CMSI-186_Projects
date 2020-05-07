@del TestResults.txt
@del BinaryClockSolver.class
@rmdir /Q /S docs

@mkdir docs
@javadoc -d docs BinaryClockSolver.java
@javac BinaryClockSolver.java

@echo Creating TestResults text file...
echo Test Results >> TestResults.txt
@echo Testing the class with incorrectly formatted times...
echo Testing the class with incorrectly formatted times...
java BinaryClockSolver hey there, how's it going? >> TestResults.txt
echo . >> TestResults.txt
java BinaryClockSolver aa:bb:cc >> TestResults.txt
echo . >> TestResults.txt
java BinaryClockSolver 12:55 >> TestResults.txt
echo . >> TestResults.txt
java BinaryClockSolver 25:61:72 >> TestResults.txt
echo . >> TestResults.txt
java BinaryClockSolver -4:-8:25 >> TestResults.txt
echo . >> TestResults.txt
@echo Testing the class with correctly formatted times...
echo Testing the class with correctly formatted times...
java BinaryClockSolver 01:44:45 >> TestResults.txt
echo . >> TestResults.txt
java BinaryClockSolver 06:11:12 >> TestResults.txt
echo . >> TestResults.txt
java BinaryClockSolver 09:14:59 >> TestResults.txt
echo . >> TestResults.txt
java BinaryClockSolver 11:50:50 >> TestResults.txt
echo . >> TestResults.txt
java BinaryClockSolver 12:59:01 >> TestResults.txt
echo . >> TestResults.txt
java BinaryClockSolver 23:44:09 >> TestResults.txt
echo . >> TestResults.txt
java BinaryClockSolver 22:00:00 >> TestResults.txt
echo . >> TestResults.txt
java BinaryClockSolver 00:00:00 >> TestResults.txt
echo . >> TestResults.txt
java BinaryClockSolver 01:01:01 >> TestResults.txt
echo . >> TestResults.txt
java BinaryClockSolver 18:14:10 >> TestResults.txt
echo . >> TestResults.txt
java BinaryClockSolver 05:55:50 >> TestResults.txt
echo . >> TestResults.txt
java BinaryClockSolver 11:22:33 >> TestResults.txt
echo . >> TestResults.txt
java BinaryClockSolver 13:21:35 >> TestResults.txt
echo . >> TestResults.txt
java BinaryClockSolver 14:22:36 >> TestResults.txt
echo . >> TestResults.txt
java BinaryClockSolver 23:17:41 >> TestResults.txt
echo . >> TestResults.txt
java BinaryClockSolver 11:11:11 >> TestResults.txt
echo . >> TestResults.txt
java BinaryClockSolver 15:51:15 >> TestResults.txt
echo . >> TestResults.txt
java BinaryClockSolver 07:17:27 >> TestResults.txt
echo . >> TestResults.txt
java BinaryClockSolver 17:37:57 >> TestResults.txt
echo . >> TestResults.txt
java BinaryClockSolver 23:59:59 >> TestResults.txt
echo . >> TestResults.txt