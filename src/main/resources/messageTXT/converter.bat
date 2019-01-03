FOR %%I In (*.txt) DO (

"C:\Program Files\Java\jdk1.8.0_161\bin\native2ascii" -encoding utf-8 %%I E:\WorkspacesProjects\IntelliJUlt\carService\src\main\resources\localization\%%~nI.properties
)