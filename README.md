# Quiz-App

This is a simple quiz application developed using java spring boot. The aplication contains two models, Question and Quiz. A Question
contains a question title, list of options as well as a right answer. The Quiz on the other hand has quiz title and a list of questions. The mapping done
between the two classes is ManyToMany, as many questions can have multiple quizes and vice versa. After completion of the quiz, a score is generated, based on the
the number of right answers supplied. The question and quiz classes are mapped to a tables in mySql database. 

Note. Any database can be used for this project, in this case MySql was used. This project can also be further improved on the UI side, so as to display 
 questions and also submit and get score. Lastly, as this is a simple project. You can further improve it by having a list of users in the database,
 so as to ensure that only those authenticated will be allowed access to start the quiz.
