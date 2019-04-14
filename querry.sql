-- select student.first_name, student.lastname, student.student_id, preferences.f_choice, preferences.sec_choice, preferences.third_choice, 
-- alevelsubs.subject , alevelsubs.grade, olevelsubs.subject, olevelsubs.grade
-- from student, preferences, alevelsubs, olevelsubs
-- WHERE 
-- student.student_id = preferences.student_id and student.student_id = alevelsubs.student_id
-- and student.student_id = olevelsubs.student_id;


-- Select distinct student.first_name,student.lastname,student.student_id,preferences.f_choice, preferences.sec_choice,
-- preferences.third_choice, GROUP_CONCAT(alevelsubs.subject) AS alevels , GROUP_CONCAT(alevelsubs.grade) as alevelgrades, 
-- GROUP_CONCAT(olevelsubs.subject) AS olevels, GROUP_CONCAT(olevelsubs.grade) as olevelgrades
-- from student join 
-- (preferences, alevelsubs, olevelsubs)
-- on student.student_id = preferences.student_id 
-- and student.student_id = alevelsubs.student_id
-- and student.student_id = olevelsubs.student_id;


Select distinct student.first_name,student.lastname,student.student_id,preferences.f_choice, preferences.sec_choice,
preferences.third_choice,
    (select GROUP_CONCAT(alevelsubs.subject) 
    from alevelsubs where student.student_id = alevelsubs.student_id ) AS alevels,
    (select GROUP_CONCAT(alevelsubs.grade)
    from alevelsubs where student.student_id = alevelsubs.student_id)  as alevelgrades,
    (select GROUP_CONCAT(olevelsubs.subject) 
    from olevelsubs where student.student_id = olevelsubs.student_id) AS olevels, 
    (select GROUP_CONCAT(olevelsubs.grade) 
    from olevelsubs where student.student_id = olevelsubs.student_id) as olevelgrades
    from preferences, student, alevelsubs, olevelsubs
where student.student_id = preferences.student_id 
and student.student_id = alevelsubs.student_id
and student.student_id = olevelsubs.student_id;



DELETE FROM `results` WHERE student_id  = 100 OR 101 OR 102 OR 103 OR 104;

UPDATE `student` SET `selected_for`= null WHERE student_id =  100 or 101 or 102 or 103 or 104 or 105;




Select distinct student.first_name,student.lastname,student.student_id,preferences.f_choice, preferences.sec_choice, preferences.third_choice, student.selected_for,
				(select GROUP_CONCAT(alevelsubs.subject)
				from alevelsubs where student.student_id = alevelsubs.student_id ) AS alevels,
				(select GROUP_CONCAT(alevelsubs.grade)
				from alevelsubs where student.student_id = alevelsubs.student_id)  as alevelgrades,
				(select GROUP_CONCAT(olevelsubs.subject)
				from olevelsubs where student.student_id = olevelsubs.student_id) AS olevels,
				(select GROUP_CONCAT(olevelsubs.grade)
				from olevelsubs where student.student_id = olevelsubs.student_id) as olevelgrades
				from preferences, student, alevelsubs, olevelsubs
				where student.student_id = preferences.student_id and student.student_id = alevelsubs.student_id and student.student_id = olevelsubs.student_id;
                