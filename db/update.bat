@echo off
cls

echo Deleting
cmd /c "C:\laragon\bin\mysql\mysql-8.0.30-winx64\bin\mysqladmin.exe -u root -p drop click_n_clean"

echo Creating new 
cmd /c "C:\laragon\bin\mysql\mysql-8.0.30-winx64\bin\mysqladmin.exe -u root -p create click_n_clean"

echo Loading sql file
cmd /c "C:\laragon\bin\mysql\mysql-8.0.30-winx64\bin\mysql.exe -u root -p click_n_clean < db/click_n_clean.sql"

