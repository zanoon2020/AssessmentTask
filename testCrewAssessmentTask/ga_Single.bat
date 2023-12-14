@echo off
:: If you already have a valid JAVA_HOME environment variable set, feel free to comment the below two lines
set JAVA_HOME=D:\jdk-17_windows-x64_bin\jdk-17.0.1
set path=%JAVA_HOME%\bin;%path%
set path=C:\Users\Ahmed Zanoon\.m2\repository\allure\allure-2.25.0\bin;%path%
setlocal enabledelayedexpansion

REM Get today's date in the "YYYY-MM-DD" format
REM for /f "delims=" %%a in ('wmic os get localdatetime ^| find "."') do set datetime=%%a
REM This line uses a for loop to capture the output of the wmic os get localdatetime command, 
REM which provides the current date and time in the "YYYYMMDDHHMMSS" format. 
REM The find "." part is used to filter out any lines that contain a dot (".") since the actual output contains extra characters. 
REM The result is stored in the variable datetime.
for /f "delims=" %%a in ('wmic os get localdatetime ^| find "."') do set datetime=%%a
set "year=!datetime:~0,4!"
set "month=!datetime:~4,2!"
set "day=!datetime:~6,2!"
set "hour=!datetime:~8,2!"
set "minute=!datetime:~10,2!"
set "second=!datetime:~12,2!"
set "folder_name=!year!!month!!day!!hour!!minute!!second!"

REM Create a new folder with today's date
REM mkdir "!folder_name!"

call allure generate --single-file allure-results  -o "allure-report/!folder_name!/"
echo Folder Name: !folder_name!

set "max_attempts=3"
set "attempts=0"

:WAIT_LOOP
if not exist "allure-report\!folder_name!\index.html" (
    set /A "attempts+=1"
    if !attempts! lss %max_attempts% (
        echo File not found. Waiting and retrying...
        timeout /nobreak /t 5 >nul 2>&1
        goto WAIT_LOOP
    ) else (
        echo Maximum number of attempts reached. Exiting script.
        goto :EOF
    )
) else (
    echo File found. Proceeding with the rename.
    move "allure-report\!folder_name!\index.html" "allure-report\!folder_name!\AllureReport_!folder_name!.html"
)

call start allure-report/!folder_name!/AllureReport_!folder_name!.html"
REM call allure open "allure-report/!folder_name!/!folder_name!_Report_name.html" -h localhost

pause
exit