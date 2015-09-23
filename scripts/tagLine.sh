#!/bin/bash

CLASSPATH="lib/lingpipe-4.1.0.jar:dist/diseaseDrug-1.2.jar:./lib/commons-io-2.4.jar"
RESULT_DIR="./test/"

for file in $1/*.srt
do
  TMP_FILE=$RESULT_DIR/`basename $file`.tmp
  grep -e "^[^0-9]" $file > $TMP_FILE
  RESULT_FILE=$RESULT_DIR/`basename $file`.ann
  java -cp $CLASSPATH info.chenli.mooc.ner.ApproximateNER "${TMP_FILE}" > $RESULT_FILE
  rm -f $TMP_FILE
done
