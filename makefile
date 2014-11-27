all:
	javac Item/*.java
	javac RPG.java
clean:
	rm Item/*.class
	rm *.class
run:
	java RPG
