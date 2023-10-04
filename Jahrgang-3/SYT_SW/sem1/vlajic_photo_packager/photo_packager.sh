#!/bin/bash
echo Photo-Packager V0.1
echo ===================

echo Wie heißt du?
read name 
echo Hallo, $name!

name2=$(whoami)
echo Hallo $name2, wir haben $(date)

echo "chmod 664 filename.text = {owner: xrw, groups and users: r}"

#photo-packager

#init
imgPath="./website/photos"
websitePath="./website/index.html"
docStart="<html><head><title>Foto-Index</title></head><body>
	<h1>Foto-Index</h1><table>"

docEnd="</table></body></html>"


#create txt data and save picturenames 

ls -a $imgPath > "./website/photoList.txt"

echo $docStart > $websitePath

#<tr><td></td><td><img src="" alt="" ></td></tr>

while IFS= read -r line; do
	echo "<tr><td>$line</td><td><img src="./photos/$line" alt="" ></td></tr>" >> $websitePath
done < "./website/photoList.txt"

echo $docEnd >> $websitePath

cat $websitePath

tar -czvf website.tar.gz ./website
