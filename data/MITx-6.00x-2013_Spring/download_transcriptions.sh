#!/bin/bash

for f in /data/sls/u/cli/projects/mooc/MITx/MITx-6.00x-2013_Spring/home/daries/temp_zip/MITx-6.00x-2013_Spring/video/*.xml
do
    url=`grep -o "src=\"[^\"]\+.srt" $f | sed "s/src=\"//g"`
    file_name=`basename $f .xml`
    if [ "${url}" == "" ];then
        echo "No transcription url for ${f}."
        continue;
    fi
    echo "curl \"$url\" > \"./transcriptions/${file_name}.srt\""
    curl "$url" > "./transcriptions/${file_name}.srt"
done
