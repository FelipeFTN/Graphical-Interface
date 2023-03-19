# Linux & Mac
echo "[+] find java files"
find -name "*.java" > sources.txt
echo "[+] compile"
javac -d ./bin @sources.txt
# echo "[+] class to jar"
# jar cvfm DarkLegend.jar MANIFEST.MF ./bin/**
# echo "[+] run"
# java -jar DarkLegend.jar

# Windows
# dir /s /B *.java > sources.txt
# javac @sources.txt
