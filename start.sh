find * -name "*.java" > sources.txt
javac @sources.txt
cd src && java edu.school21.Simulator ../scenario.txt
find * -name "*.class" -exec rm -rf {} \;
rm -rf ../sources.txt
