JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Game.java \
	Board.java \
	TicTacToe.java 
	
default: classes test

classes: $(CLASSES:.java=.class)

test: JunitTest.java
	javac -cp junit-4.12.jar:hamcrest-core-1.3.jar:. JunitTest.java
clean:
	rm *.class
