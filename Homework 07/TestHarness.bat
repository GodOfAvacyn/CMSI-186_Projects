@del TestResults.txt
@del BirthdaySolver.class
@rmdir /Q /S docs

@mkdir docs
@javadoc -d docs BirthdaySolver.java
@javac BirthdaySolver.java

@echo Creating TestResults file...
echo Test Results >> TestResults.txt

@echo Testing jibberish...
echo Running BirthdaySolver with asdf and laskdfh as inputs... >> TestResults.txt
java BirthdaySolver asdf laskdfa >> TestResults.txt
echo . >> TestResults.txt

@echo Testing very large values...
echo Running BirthdaySolver with 500 and 100000000 as inputs... >> TestResults.txt
java BirthdaySolver 500 100000000 >> TestResults.txt
echo . >> TestResults.txt

@echo Testing a myriad of different values...
echo Running BirthdaySolver with 5 and 100... >> TestResults.txt
java BirthdaySolver 5 100 >> TestResults.txt
echo Running BirthdaySolver with 5 and 1000... >> TestResults.txt
java BirthdaySolver 5 1000 >> TestResults.txt
echo Running BirthdaySolver with 5 and 100000... >> TestResults.txt
java BirthdaySolver 5 10000 >> TestResults.txt
echo Running BirthdaySolver with 5 and 5000000... >> TestResults.txt
java BirthdaySolver 5 5000000 >> TestResults.txt
echo . >> TestResults.txt

echo Running BirthdaySolver with 10 and 100... >> TestResults.txt
java BirthdaySolver 10 100 >> TestResults.txt
echo Running BirthdaySolver with 10 and 1000... >> TestResults.txt
java BirthdaySolver 10 1000 >> TestResults.txt
echo Running BirthdaySolver with 10 and 100000... >> TestResults.txt
java BirthdaySolver 10 10000 >> TestResults.txt
echo Running BirthdaySolver with 10 and 5000000... >> TestResults.txt
java BirthdaySolver 10 5000000 >> TestResults.txt
echo . >> TestResults.txt

echo Running BirthdaySolver with 30 and 100... >> TestResults.txt
java BirthdaySolver 30 100 >> TestResults.txt
echo Running BirthdaySolver with 30 and 1000... >> TestResults.txt
java BirthdaySolver 30 1000 >> TestResults.txt
echo Running BirthdaySolver with 30 and 100000... >> TestResults.txt
java BirthdaySolver 30 100000 >> TestResults.txt
echo Running BirthdaySolver with 30 and 5000000... >> TestResults.txt
java BirthdaySolver 30 5000000 >> TestResults.txt
echo . >> TestResults.txt

echo Running BirthdaySolver with 60 and 100... >> TestResults.txt
java BirthdaySolver 60 100 >> TestResults.txt
echo Running BirthdaySolver with 60 and 1000... >> TestResults.txt
java BirthdaySolver 60 1000 >> TestResults.txt
echo Running BirthdaySolver with 60 and 100000... >> TestResults.txt
java BirthdaySolver 60 100000 >> TestResults.txt
echo Running BirthdaySolver with 60 and 5000000... >> TestResults.txt
java BirthdaySolver 60 5000000 >> TestResults.txt
echo . >> TestResults.txt

echo Running BirthdaySolver with 100 and 100... >> TestResults.txt
java BirthdaySolver 100 100 >> TestResults.txt
echo Running BirthdaySolver with 100 and 1000... >> TestResults.txt
java BirthdaySolver 100 1000 >> TestResults.txt
echo Running BirthdaySolver with 100 and 100000... >> TestResults.txt
java BirthdaySolver 100 100000 >> TestResults.txt
echo Running BirthdaySolver with 100 and 5000000... >> TestResults.txt
java BirthdaySolver 100 5000000 >> TestResults.txt
echo . >> TestResults.txt