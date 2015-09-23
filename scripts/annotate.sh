for f in $1/*
do
  java -cp lib/lingpipe-4.1.0.jar:dist/diseaseDrug-1.2.jar:lib/commons-io-2.4.jar info.chenli.mooc.ner.ApproximateNER $f > ./results/`basename $f`
done

