#!/bin/bash
cat SalesJan2009.csv
clear
cat SalesJan2009.csv | grep "Mastercard" | wc -l
cat ./SalesJan2009.csv | grep -i "adam" | wc -l
cat ./SalesJan2009.csv | grep -i 'adam\|Transaction_date' | cut -d "," -f1-5

#cat ./SalesJan2009.csv | grep -i 'adam\|Transaction_date' | cut -d "," -f1,2,5,8 >
#ergebnis.csv

cat ./SalesJan2009.csv | head -1 > VisaSalesJan2009.csv && cat ./SalesJan2009.csv | grep "Visa" | cut -d "," -f1-2,4-6,11-13 >> VisaSalesJan2009.csv


