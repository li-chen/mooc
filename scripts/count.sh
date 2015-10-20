#!/bin/bash

CLASS_PATH="./dist/diseaseDrug-1.2.jar"

echo -e "FileName\tRowNumber\tPeriodNumber\tSentenceWithKeywords\tKeywordsNumber"

for f in ./data/MITx-6.00x-2013_Spring/transcriptions/*.srt
do
    let NUM_ROW=`cat $f | wc -l`/4

    NUM_period=`grep -P "\.$" ${f} | wc -l`
    NUM_question=`grep -P "\?$" ${f} | wc -l`
    let NUM=${NUM_period}+${NUM_question}
    echo -e "`basename $f .srt`\t$NUM_ROW\t$NUM`java -cp $CLASS_PATH info.chenli.mooc.semantic.TranscriptionAnnotator $f`"
done
