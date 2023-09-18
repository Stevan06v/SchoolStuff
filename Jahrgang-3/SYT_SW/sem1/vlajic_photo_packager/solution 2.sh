#!/bin/bash

#cd ~/script/
#mk dir photo-packager
#cd photo-packager
#touch package-photos.sh
#chmod -R 444 ~/script/photo-packager
#cd photo-packager
#chmod 744 package-photos.sh
#...

echo Photo-Packager V0.1
echo ===================
date
echo Griasdi, $USER!


ls ./images > index.txt
images=$(ls ./images)
echo "<html>
    <head>
        <title>Foto-Index</title>
    </head>
    <body>
        <h1>Foto-Index</h1>
        <table>" > index.html

for image in $images
do
    echo " <tr>
                <td>$image</td>
                <td><img src='./images/$image' alt='lass es' ></td>
            </tr>" >> index.html
done
echo "</table>
    </body>
</html>" >> index.html

tar -cf photos.tar.gz images

