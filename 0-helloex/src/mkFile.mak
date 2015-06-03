JFLAGS = -g
JC = javac
JVM= java 
FILE=
RM = del

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	com\proga\Printer.java \
	com\proga\HelloWorld.java
	
MAIN = com.proga.HelloWorld

target: classes

classes: $(CLASSES:.java=.class)

target: run

run:
	$(JVM) $(MAIN)

target: clean
clean:
	$(RM) com\proga\*.class