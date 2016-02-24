#!/bin/sh

if [ -z "$JAVA_HOME" ] ; then
  JAVA=`/usr/bin/which java`
  if [ -z "$JAVA" ] ; then
    echo "Cannot find JAVA. Please set your PATH."
    exit 1
  fi
  JAVA_BIN=`dirname $JAVA`
  JAVA_HOME=$JAVA_BIN/..
else
  JAVA=$JAVA_HOME/bin/java
fi

echo "JAVA=$JAVA"

LCP=.:$JAVA_HOME/lib/tools.jar:$LCP
LCP=lib/xlattice/util-0.3.14.jar:$LCP
LCP=target/classes:$LCP

CMD="$JAVA $OPTS -classpath $LCP org.xlattice.xlReg.XLRegJClient $@ "
echo $CMD
$CMD
