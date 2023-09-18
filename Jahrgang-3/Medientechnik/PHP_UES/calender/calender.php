<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calender</title>
    <link rel="stylesheet" href="./style.css">
    <script src="./script.js" defer></script>
</head>

<body>
    <?php
    setlocale(LC_TIME, "de_DE.utf8");
    $kal_datum = time();
    $kal_tage_gesamt = date("t", $kal_datum);
    $kal_start_timestamp = mktime(0, 0, 0, date("n", $kal_datum), 1, date("Y", $kal_datum));
    $kal_start_tag = date("N", $kal_start_timestamp);
    $kal_ende_tag = date("N", mktime(0, 0, 0, date("n", $kal_datum), $kal_tage_gesamt, date("Y", $kal_datum)));
    ?>


    <table class="kalender" style="text-align: center; ">
        <caption><?php echo utf8_decode(strftime("%B %Y", $kal_datum)); ?></caption>
        <thead>
            <tr>
                <th>Mo</th>
                <th>Di</th>
                <th>Mi</th>
                <th>Do</th>
                <th>Fr</th>
                <th>Sa</th>
                <th>So</th>
            </tr>
        </thead>
        <tbody>
            <?php

            $count = 0;
            $dates = array();

            // selbst geparst jajajaja
            if (is_file('data2023.csv')) {
                $data = explode("\n", file_get_contents('data2023.csv'));
                foreach ($data as $iterator) {
                    if ($count >= 1) {
                        $attributes = explode(",", $iterator);

                        $start_date = $attributes[1];
                        $subject = $attributes[0];
                        $start_time = $attributes[2];
                        $end_time = $attributes[4];

                        $temp_data = array(
                            $start_date,
                            $subject,
                            $start_time,
                            $end_time
                        );
                        for ($i = 0; $i < sizeof($temp_data); $i++) {
                            $temp_data[$i] =  str_replace('"', "", $temp_data[$i]);
                        }
                        array_push($dates, $temp_data);
                    }
                    $count++;
                }
            }

            for ($i = 1; $i <= $kal_tage_gesamt + ($kal_start_tag - 1) + (7 - $kal_ende_tag); $i++) {
                $kal_anzeige_akt_tag = $i - $kal_start_tag;
                $kal_anzeige_heute_timestamp = strtotime($kal_anzeige_akt_tag . " day", $kal_start_timestamp);
                $kal_anzeige_heute_tag = date("j", $kal_anzeige_heute_timestamp);


                if (date("N", $kal_anzeige_heute_timestamp) == 1) {
                    echo "    <tr>\n";
                }
                if (
                    date("dmY", $kal_datum) == date("dmY", $kal_anzeige_heute_timestamp)
                ) {
                    echo "<td class='kal_aktueller_tag'>";
                    echo $kal_anzeige_heute_tag;
                    printEntry($kal_anzeige_heute_timestamp);

                    echo  "</td>\n";
                } else if ($kal_anzeige_akt_tag >= 0 and $kal_anzeige_akt_tag < $kal_tage_gesamt) {
                    echo "<td class=\"kal_standard_tag\">";
                    echo  $kal_anzeige_heute_tag;
                    printEntry($kal_anzeige_heute_timestamp);
                    echo "</td>\n";
                } else {
                    echo "<td class=\"kal_vormonat_tag\">";
                    printEntry($kal_anzeige_heute_timestamp);
                    echo "</td>\n";
                }
                if (date("N", $kal_anzeige_heute_timestamp) == 7) {
                    echo "    </tr>\n";
                }
            }

            function printEntry($date)
            {
                $date = date("d/m/Y", $date);
                $html = "";
                global $dates;
                for ($i = 0; $i < sizeof($dates); $i++) {
                    if (strtotime($dates[$i][0]) == strtotime($date)) {
                        for ($j = 0; $j < sizeof($dates[$i]) - 1; $j++) {
                            $html = $html . "<p>"  . $dates[$i][$j + 1] . "</p>";
                        }
                    }
                }
                echo "<div>"  . $html . "</div>";
            }

            printStats();

            // puhhhh :(
            function printStats()
            {
                global $dates;
                $counter = array();
                $hasItem = array(0);
                for ($i = 0; $i < sizeof($dates); $i++) {
                    if (!in_array($dates[$i][1], $hasItem)) {
                        $hasItem[$i] = $dates[$i][1];
                        $counter[$i] = getCount($dates[$i][1]);
                        print($dates[$i][1] . ": " . $counter[$i] . "<br>");
                    }
                }
            }
            function getCount($element)
            {
                global $dates;
                $count = 0;
                for ($i = 0; $i < sizeof($dates); $i++) {
                    if ($dates[$i][1] == $element) {
                        $count++;
                    }
                }
                return $count;
            }

            ?>
        </tbody>
    </table>
</body>
</html>