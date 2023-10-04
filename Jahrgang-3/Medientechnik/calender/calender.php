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

            //write me a bubble sort
            if (is_file('data2023.csv')) {
                $data = explode("\n", file_get_contents('data2023.csv'));
                foreach ($data as $iterator) {
                    if ($count >= 1) {
                        $attributes = explode(",", $iterator);

                        $start_date = $attributes[0];
                        $subject = $attributes[1];
                        $start_time = $attributes[2];
                        $end_date = $attributes[3];
                        $end_time = $attributes[4];
                        $all_day_event = $attributes[5];
                        $reminder = $attributes[6];
                        $reminder_date = $attributes[7];
                        $reminder_time = $attributes[8];
                        $reminder_categories = $attributes[9];
                        $description = $attributes[10];
                        $location = $attributes[11];
                        $private = $attributes[12];

                        $temp_data = array(
                            $start_date,
                            $subject,
                            $start_time,
                            $end_date,
                            $end_time,
                            $all_day_event,
                            $reminder,
                            $reminder_date,
                            $reminder_time,
                            $reminder_categories,
                            $description,
                            $location,
                            $private
                        );

                        for ($i = 0; $i < sizeof($temp_data); $i++) {
                            $temp_data[$i] =  str_replace('"', "", $temp_data[$i]);
                        }

                        array_push($dates, $temp_data);
                    }
                    $count++;
                }
            }

            //12.35.22
            //12.34.26
            //12.34.22
            //12.34.24
            //12.34.27

            //"Subject","Start Date","Start Time","End Date","End Time","All day event","Reminder on/off","Reminder Date","Reminder Time","Categories","Description","Location","Private"


            for ($i = 1; $i <= $kal_tage_gesamt + ($kal_start_tag - 1) + (7 - $kal_ende_tag); $i++) {
                $kal_anzeige_akt_tag = $i - $kal_start_tag;
                print($kal_anzeige_akt_tag);
                $kal_anzeige_heute_timestamp = strtotime($kal_anzeige_akt_tag . " day", $kal_start_timestamp);
                $kal_anzeige_heute_tag = date("j", $kal_anzeige_heute_timestamp);

                if (date("N", $kal_anzeige_heute_timestamp) == 1) {
                    echo "    <tr>\n";
                }


                if (
                    date("dmY", $kal_datum) == date("dmY", $kal_anzeige_heute_timestamp)
                ) {
                    echo "<td class=\"kal_aktueller_tag\">", $kal_anzeige_heute_tag, "</td>\n";


                } else if ($kal_anzeige_akt_tag >= 0 and $kal_anzeige_akt_tag < $kal_tage_gesamt) {
                    echo "<td class=\"kal_standard_tag\">", $kal_anzeige_heute_tag, "</td>\n";

                } else {
                    echo "<td class=\"kal_vormonat_tag\">", $kal_anzeige_heute_tag, "</td>\n";

                }
                if (date("N", $kal_anzeige_heute_timestamp) == 7) {
                    echo "    </tr>\n";
                }
            }

            //echo $dates[5][1];



            function printEntry($date)
            {
                global $dates;
                for ($i = 0; $i < sizeof($dates); $i++) {
                    for ($j = 0; $j < sizeof($dates[$i]); $j++) {
                        if ($dates[$i][1] == $date) {
                            echo $dates[$i][$j];
                        }
                    }
                }
            }



            ?>
        </tbody>
    </table>
</body>

</html>