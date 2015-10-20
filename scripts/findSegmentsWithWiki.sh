CLASSPATH="dist/diseaseDrug-1.2.jar:./lib/uimafit-core-2.1.0.jar"
for f in ./data/MITx-6.00x-2013_Spring/transcriptions/*.srt
do
    java -cp $CLASSPATH info.chenli.mooc.semantic.TranscriptionAnnotator $f
done
