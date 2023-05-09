/*const gpa = document.querySelector(".gpa")
const gpaSideBar = document.querySelector(".gpa-sidebar")
const closegpa = document.querySelector(".close-gpa")
const stack = document.querySelector(".stack")
const menuSidebar = document.querySelector(".menu-sidebar")
const closeMenu = document.querySelector(".close-menu")
const gpaTotal = document.querySelector(".total-gpa")
const gpaUi = document.querySelector(".gpa-sidebar .gpa")
const clearnBtn = document.querySelector(".clear-gpa-btn")
const gpaContent = document.querySelector(".gpa-content") 
const MasterDRP = document.querySelector(".dropdown") 
const Master = document.querySelector(".MasterDROP")



gpa.addEventListener("click",function(){
    gpaSideBar.style.transform = "translate(0%)"
})

closegpa.addEventListener("click",function(){
    gpaSideBar.style.transform = "translate(100%)"
    
})

stack.addEventListener("click",function(){
    menuSidebar.style.transform = "translate(0%)"
})

closeMenu.addEventListener("click",function(){
    menuSidebar.style.transform = "translate(-100%)"
})


/*DropArea
const initApp = () => {
    const droparea = document.querySelector('.droparea');

    const active = () => droparea.classList.add("green-border");

    const inactive = () => droparea.classList.remove("green-border");

    const prevents = (e) => e.preventDefault();

    ['dragenter', 'dragover', 'dragleave', 'drop'].forEach(evtName => {
        droparea.addEventListener(evtName, prevents);
    });

    ['dragenter', 'dragover'].forEach(evtName => {
        droparea.addEventListener(evtName, active);
    });

    ['dragleave', 'drop'].forEach(evtName => {
        droparea.addEventListener(evtName, inactive);
    });

    droparea.addEventListener("drop", handleDrop);

}*/

/*document.addEventListener("DOMContentLoaded", initApp);

const handleDrop = (e) => {
    alert('File sucessfully uploaded!')
    const dt = e.dataTransfer;
    const files = dt.files;
    const fileArray = [...files];
    console.log(files); // FileList
    console.log(fileArray);
}*/








/* Intelligent rows*/
function addCourse() {
    var table = document.getElementById("core-list");
    var row = table.insertRow(table.rows.length);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);
   
   

    var select = document.createElement("select");
    var option1 = document.createElement("option");
    var option2 = document.createElement("option");
    var option3 = document.createElement("option");
    option1.text = "Select";
    option2.text = "Yes";
    option3.text = "No";
    select.add(option1);
    select.add(option2);
    select.add(option3);


   
    var select1 = document.createElement("select");
    var option1 = document.createElement("option");
    var option2 = document.createElement("option");
    var option3 = document.createElement("option");
    var option4 = document.createElement("option");
    var option5 = document.createElement("option");
    var option6 = document.createElement("option");
    var option7 = document.createElement("option");
    var option8 = document.createElement("option");
    var option9 = document.createElement("option");
    var option10 = document.createElement("option");
    var option11 = document.createElement("option");
    var option12 = document.createElement("option");

    option1.text = "Select";
    option2.text = "A";
    option3.text = "A-";
    option4.text = "A+";
    option5.text = "B";
    option6.text = "B-";
    option7.text = "B+";
    option8.text = "C";
    option9.text = "C-";
    option10.text = "C+";
    option11.text = "D";
    option12.text = "F";

    select1.add(option1);
    select1.add(option2);
    select1.add(option3);
    select1.add(option4);
    select1.add(option5);
    select1.add(option6);
    select1.add(option7);
    select1.add(option8);
    select1.add(option9);
    select1.add(option10);
    select1.add(option11);
    select1.add(option12);


    cell1.contentEditable = "true";
    cell2.contentEditable = "true";
    cell3.contentEditable = "true";
    cell4.appendChild(select);
    cell5.appendChild(select1);
    
    
   
}
function deleteCourse() {
    var table = document.getElementById("core-list").deleteRow(0-1);
}

function addCourse2() {
    var table = document.getElementById("five-list");
    var row = table.insertRow(table.rows.length);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3); 
    var cell5 = row.insertCell(4);
    var cell6 = row.insertCell(5);

    var select = document.createElement("select");
    var option1 = document.createElement("option");
    var option2 = document.createElement("option");
    var option3 = document.createElement("option");
    option1.text = "Select";
    option2.text = "Yes";
    option3.text = "No";
    select.add(option1);
    select.add(option2);
    select.add(option3);


   
    var select1 = document.createElement("select");
    var option1 = document.createElement("option");
    var option2 = document.createElement("option");
    var option3 = document.createElement("option");
    var option4 = document.createElement("option");
    var option5 = document.createElement("option");
    var option6 = document.createElement("option");
    var option7 = document.createElement("option");
    var option8 = document.createElement("option");
    var option9 = document.createElement("option");
    var option10 = document.createElement("option");
    var option11 = document.createElement("option");
    var option12 = document.createElement("option");

    option1.text = "Select";
    option2.text = "A";
    option3.text = "A-";
    option4.text = "A+";
    option5.text = "B";
    option6.text = "B-";
    option7.text = "B+";
    option8.text = "C";
    option9.text = "C-";
    option10.text = "C+";
    option11.text = "D";
    option12.text = "F";

    select1.add(option1);
    select1.add(option2);
    select1.add(option3);
    select1.add(option4);
    select1.add(option5);
    select1.add(option6);
    select1.add(option7);
    select1.add(option8);
    select1.add(option9);
    select1.add(option10);
    select1.add(option11);
    select1.add(option12);


    cell1.contentEditable = "true";
    cell2.contentEditable = "true";
    cell3.contentEditable = "true";
    cell4.contentEditable = "true";
    cell5.appendChild(select);
    cell6.appendChild(select1);

    
}
function deleteCourse2() {
    var table = document.getElementById("five-list").deleteRow(0-1);
}


function addCourse3() {
    var table = document.getElementById("AdditionalE-list");
    var row = table.insertRow(table.rows.length);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);
    var cell6 = row.insertCell(5);
    
    var select = document.createElement("select");
    var option1 = document.createElement("option");
    var option2 = document.createElement("option");
    var option3 = document.createElement("option");
    option1.text = "Select";
    option2.text = "Yes";
    option3.text = "No";
    select.add(option1);
    select.add(option2);
    select.add(option3);


   
    var select1 = document.createElement("select");
    var option1 = document.createElement("option");
    var option2 = document.createElement("option");
    var option3 = document.createElement("option");
    var option4 = document.createElement("option");
    var option5 = document.createElement("option");
    var option6 = document.createElement("option");
    var option7 = document.createElement("option");
    var option8 = document.createElement("option");
    var option9 = document.createElement("option");
    var option10 = document.createElement("option");
    var option11 = document.createElement("option");
    var option12 = document.createElement("option");

    option1.text = "Select";
    option2.text = "A";
    option3.text = "A-";
    option4.text = "A+";
    option5.text = "B";
    option6.text = "B-";
    option7.text = "B+";
    option8.text = "C";
    option9.text = "C-";
    option10.text = "C+";
    option11.text = "D";
    option12.text = "F";

    select1.add(option1);
    select1.add(option2);
    select1.add(option3);
    select1.add(option4);
    select1.add(option5);
    select1.add(option6);
    select1.add(option7);
    select1.add(option8);
    select1.add(option9);
    select1.add(option10);
    select1.add(option11);
    select1.add(option12);


    cell1.contentEditable = "true";
    cell2.contentEditable = "true";
    cell3.contentEditable = "true";
    cell4.contentEditable = "true";
    cell5.appendChild(select);
    cell6.appendChild(select1);
}
function deleteCourse3() {
    var table = document.getElementById("AdditionalE-list").deleteRow(0-1);
}



function addCourse4() {
    var table = document.getElementById("Other-list");
    var row = table.insertRow(table.rows.length);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);
    var cell6 = row.insertCell(5);

    var select = document.createElement("select");
    var option1 = document.createElement("option");
    var option2 = document.createElement("option");
    var option3 = document.createElement("option");
    option1.text = "Select";
    option2.text = "Yes";
    option3.text = "No";
    select.add(option1);
    select.add(option2);
    select.add(option3);


   
    var select1 = document.createElement("select");
    var option1 = document.createElement("option");
    var option2 = document.createElement("option");
    var option3 = document.createElement("option");
    var option4 = document.createElement("option");
    var option5 = document.createElement("option");
    var option6 = document.createElement("option");
    var option7 = document.createElement("option");
    var option8 = document.createElement("option");
    var option9 = document.createElement("option");
    var option10 = document.createElement("option");
    var option11 = document.createElement("option");
    var option12 = document.createElement("option");

    option1.text = "Select";
    option2.text = "A";
    option3.text = "A-";
    option4.text = "A+";
    option5.text = "B";
    option6.text = "B-";
    option7.text = "B+";
    option8.text = "C";
    option9.text = "C-";
    option10.text = "C+";
    option11.text = "D";
    option12.text = "F";

    select1.add(option1);
    select1.add(option2);
    select1.add(option3);
    select1.add(option4);
    select1.add(option5);
    select1.add(option6);
    select1.add(option7);
    select1.add(option8);
    select1.add(option9);
    select1.add(option10);
    select1.add(option11);
    select1.add(option12);


    cell1.contentEditable = "true";
    cell2.contentEditable = "true";
    cell3.contentEditable = "true";
    cell4.contentEditable = "true";
    cell5.appendChild(select);
    cell6.appendChild(select1);
}
function deleteCourse4() {
    var table = document.getElementById("Other-list").deleteRow(0-1);
}



function addCourse5() {
    var table = document.getElementById("pre-list");
    var row = table.insertRow(table.rows.length);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);

    var select = document.createElement("select");
    var option1 = document.createElement("option");
    var option2 = document.createElement("option");
    var option3 = document.createElement("option");
    option1.text = "Select";
    option2.text = "Yes";
    option3.text = "No";
    select.add(option1);
    select.add(option2);
    select.add(option3);


   
    var select1 = document.createElement("select");
    var option1 = document.createElement("option");
    var option2 = document.createElement("option");
    var option3 = document.createElement("option");
    var option4 = document.createElement("option");
    var option5 = document.createElement("option");
    var option6 = document.createElement("option");
    var option7 = document.createElement("option");
    var option8 = document.createElement("option");
    var option9 = document.createElement("option");
    var option10 = document.createElement("option");
    var option11 = document.createElement("option");
    var option12 = document.createElement("option");

    option1.text = "Select";
    option2.text = "A";
    option3.text = "A-";
    option4.text = "A+";
    option5.text = "B";
    option6.text = "B-";
    option7.text = "B+";
    option8.text = "C";
    option9.text = "C-";
    option10.text = "C+";
    option11.text = "D";
    option12.text = "F";

    select1.add(option1);
    select1.add(option2);
    select1.add(option3);
    select1.add(option4);
    select1.add(option5);
    select1.add(option6);
    select1.add(option7);
    select1.add(option8);
    select1.add(option9);
    select1.add(option10);
    select1.add(option11);
    select1.add(option12);


    cell1.contentEditable = "true";
    cell2.contentEditable = "true";
    cell3.contentEditable = "true";
    cell4.appendChild(select);
    cell5.appendChild(select1);
}
function deleteCourse5() {
    var table = document.getElementById("pre-list").deleteRow(0-1);
}
/*-----------------------------------------------------------------------------*/

/*CyberSecurityRows*/
function addCourse6() {
    var table = document.getElementById("TwoAI-list");
    var row = table.insertRow(table.rows.length);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3); 
    var cell5 = row.insertCell(4);
    var cell6 = row.insertCell(5);

    var select = document.createElement("select");
    var option1 = document.createElement("option");
    var option2 = document.createElement("option");
    var option3 = document.createElement("option");
    option1.text = "Select";
    option2.text = "Yes";
    option3.text = "No";
    select.add(option1);
    select.add(option2);
    select.add(option3);


   
    var select1 = document.createElement("select");
    var option1 = document.createElement("option");
    var option2 = document.createElement("option");
    var option3 = document.createElement("option");
    var option4 = document.createElement("option");
    var option5 = document.createElement("option");
    var option6 = document.createElement("option");
    var option7 = document.createElement("option");
    var option8 = document.createElement("option");
    var option9 = document.createElement("option");
    var option10 = document.createElement("option");
    var option11 = document.createElement("option");
    var option12 = document.createElement("option");

    option1.text = "Select";
    option2.text = "A";
    option3.text = "A-";
    option4.text = "A+";
    option5.text = "B";
    option6.text = "B-";
    option7.text = "B+";
    option8.text = "C";
    option9.text = "C-";
    option10.text = "C+";
    option11.text = "D";
    option12.text = "F";

    select1.add(option1);
    select1.add(option2);
    select1.add(option3);
    select1.add(option4);
    select1.add(option5);
    select1.add(option6);
    select1.add(option7);
    select1.add(option8);
    select1.add(option9);
    select1.add(option10);
    select1.add(option11);
    select1.add(option12);


    cell1.contentEditable = "true";
    cell2.contentEditable = "true";
    cell3.contentEditable = "true";
    cell4.contentEditable = "true";
    cell5.appendChild(select);
    cell6.appendChild(select1);

    
}
function deleteCourse6() {
    var table = document.getElementById("TwoAI-list").deleteRow(0-1);
}


function addCourse7() {
    var table = document.getElementById("Appr-6000");
    var row = table.insertRow(table.rows.length);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);
    var cell6 = row.insertCell(5);
    
    var select = document.createElement("select");
    var option1 = document.createElement("option");
    var option2 = document.createElement("option");
    var option3 = document.createElement("option");
    option1.text = "Select";
    option2.text = "Yes";
    option3.text = "No";
    select.add(option1);
    select.add(option2);
    select.add(option3);


   
    var select1 = document.createElement("select");
    var option1 = document.createElement("option");
    var option2 = document.createElement("option");
    var option3 = document.createElement("option");
    var option4 = document.createElement("option");
    var option5 = document.createElement("option");
    var option6 = document.createElement("option");
    var option7 = document.createElement("option");
    var option8 = document.createElement("option");
    var option9 = document.createElement("option");
    var option10 = document.createElement("option");
    var option11 = document.createElement("option");
    var option12 = document.createElement("option");

    option1.text = "Select";
    option2.text = "A";
    option3.text = "A-";
    option4.text = "A+";
    option5.text = "B";
    option6.text = "B-";
    option7.text = "B+";
    option8.text = "C";
    option9.text = "C-";
    option10.text = "C+";
    option11.text = "D";
    option12.text = "F";

    select1.add(option1);
    select1.add(option2);
    select1.add(option3);
    select1.add(option4);
    select1.add(option5);
    select1.add(option6);
    select1.add(option7);
    select1.add(option8);
    select1.add(option9);
    select1.add(option10);
    select1.add(option11);
    select1.add(option12);


    cell1.contentEditable = "true";
    cell2.contentEditable = "true";
    cell3.contentEditable = "true";
    cell4.contentEditable = "true";
    cell5.appendChild(select);
    cell6.appendChild(select1);
}
function deleteCourse7() {
    var table = document.getElementById("Appr-6000").deleteRow(0-1);
}



function addCourse8() {
    var table = document.getElementById("Other-list");
    var row = table.insertRow(table.rows.length);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);
    var cell6 = row.insertCell(5);

    var select = document.createElement("select");
    var option1 = document.createElement("option");
    var option2 = document.createElement("option");
    var option3 = document.createElement("option");
    option1.text = "Select";
    option2.text = "Yes";
    option3.text = "No";
    select.add(option1);
    select.add(option2);
    select.add(option3);


   
    var select1 = document.createElement("select");
    var option1 = document.createElement("option");
    var option2 = document.createElement("option");
    var option3 = document.createElement("option");
    var option4 = document.createElement("option");
    var option5 = document.createElement("option");
    var option6 = document.createElement("option");
    var option7 = document.createElement("option");
    var option8 = document.createElement("option");
    var option9 = document.createElement("option");
    var option10 = document.createElement("option");
    var option11 = document.createElement("option");
    var option12 = document.createElement("option");

    option1.text = "Select";
    option2.text = "A";
    option3.text = "A-";
    option4.text = "A+";
    option5.text = "B";
    option6.text = "B-";
    option7.text = "B+";
    option8.text = "C";
    option9.text = "C-";
    option10.text = "C+";
    option11.text = "D";
    option12.text = "F";

    select1.add(option1);
    select1.add(option2);
    select1.add(option3);
    select1.add(option4);
    select1.add(option5);
    select1.add(option6);
    select1.add(option7);
    select1.add(option8);
    select1.add(option9);
    select1.add(option10);
    select1.add(option11);
    select1.add(option12);


    cell1.contentEditable = "true";
    cell2.contentEditable = "true";
    cell3.contentEditable = "true";
    cell4.contentEditable = "true";
    cell5.appendChild(select);
    cell6.appendChild(select1);
}
function deleteCourse8() {
    var table = document.getElementById("Other-list").deleteRow(0-1);
}



function addCourse9() {
    var table = document.getElementById("pre-list");
    var row = table.insertRow(table.rows.length);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);

    var select = document.createElement("select");
    var option1 = document.createElement("option");
    var option2 = document.createElement("option");
    var option3 = document.createElement("option");
    option1.text = "Select";
    option2.text = "Yes";
    option3.text = "No";
    select.add(option1);
    select.add(option2);
    select.add(option3);


   
    var select1 = document.createElement("select");
    var option1 = document.createElement("option");
    var option2 = document.createElement("option");
    var option3 = document.createElement("option");
    var option4 = document.createElement("option");
    var option5 = document.createElement("option");
    var option6 = document.createElement("option");
    var option7 = document.createElement("option");
    var option8 = document.createElement("option");
    var option9 = document.createElement("option");
    var option10 = document.createElement("option");
    var option11 = document.createElement("option");
    var option12 = document.createElement("option");

    option1.text = "Select";
    option2.text = "A";
    option3.text = "A-";
    option4.text = "A+";
    option5.text = "B";
    option6.text = "B-";
    option7.text = "B+";
    option8.text = "C";
    option9.text = "C-";
    option10.text = "C+";
    option11.text = "D";
    option12.text = "F";

    select1.add(option1);
    select1.add(option2);
    select1.add(option3);
    select1.add(option4);
    select1.add(option5);
    select1.add(option6);
    select1.add(option7);
    select1.add(option8);
    select1.add(option9);
    select1.add(option10);
    select1.add(option11);
    select1.add(option12);


    cell1.contentEditable = "true";
    cell2.contentEditable = "true";
    cell3.contentEditable = "true";
    cell4.appendChild(select);
    cell5.appendChild(select1);
}
function deleteCourse9() {
    var table = document.getElementById("pre-list").deleteRow(0-1);
}


/*-----------------------------------------------------------------------------*/


/*Software Engineering rows*/

function addCourse10() {
    var table = document.getElementById("5-list");
    var row = table.insertRow(table.rows.length);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);
    var cell6 = row.insertCell(5);

    var select = document.createElement("select");
    var option1 = document.createElement("option");
    var option2 = document.createElement("option");
    var option3 = document.createElement("option");
    option1.text = "Select";
    option2.text = "Yes";
    option3.text = "No";
    select.add(option1);
    select.add(option2);
    select.add(option3);



    var select1 = document.createElement("select");
    var option1 = document.createElement("option");
    var option2 = document.createElement("option");
    var option3 = document.createElement("option");
    var option4 = document.createElement("option");
    var option5 = document.createElement("option");
    var option6 = document.createElement("option");
    var option7 = document.createElement("option");
    var option8 = document.createElement("option");
    var option9 = document.createElement("option");
    var option10 = document.createElement("option");
    var option11 = document.createElement("option");
    var option12 = document.createElement("option");

    option1.text = "Select";
    option2.text = "A";
    option3.text = "A-";
    option4.text = "A+";
    option5.text = "B";
    option6.text = "B-";
    option7.text = "B+";
    option8.text = "C";
    option9.text = "C-";
    option10.text = "C+";
    option11.text = "D";
    option12.text = "F";

    select1.add(option1);
    select1.add(option2);
    select1.add(option3);
    select1.add(option4);
    select1.add(option5);
    select1.add(option6);
    select1.add(option7);
    select1.add(option8);
    select1.add(option9);
    select1.add(option10);
    select1.add(option11);
    select1.add(option12);


    cell1.contentEditable = "true";
    cell2.contentEditable = "true";
    cell3.contentEditable = "true";
    cell4.contentEditable = "true";
    cell5.appendChild(select);
    cell6.appendChild(select1);


}
function deleteCourse10() {
    var table = document.getElementById("5-list").deleteRow(0-1);
}



function addCourse11() {
    var table = document.getElementById("Additional-list");
    var row = table.insertRow(table.rows.length);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);
    var cell6 = row.insertCell(5);

    var select = document.createElement("select");
    var option1 = document.createElement("option");
    var option2 = document.createElement("option");
    var option3 = document.createElement("option");
    option1.text = "Select";
    option2.text = "Yes";
    option3.text = "No";
    select.add(option1);
    select.add(option2);
    select.add(option3);



    var select1 = document.createElement("select");
    var option1 = document.createElement("option");
    var option2 = document.createElement("option");
    var option3 = document.createElement("option");
    var option4 = document.createElement("option");
    var option5 = document.createElement("option");
    var option6 = document.createElement("option");
    var option7 = document.createElement("option");
    var option8 = document.createElement("option");
    var option9 = document.createElement("option");
    var option10 = document.createElement("option");
    var option11 = document.createElement("option");
    var option12 = document.createElement("option");

    option1.text = "Select";
    option2.text = "A";
    option3.text = "A-";
    option4.text = "A+";
    option5.text = "B";
    option6.text = "B-";
    option7.text = "B+";
    option8.text = "C";
    option9.text = "C-";
    option10.text = "C+";
    option11.text = "D";
    option12.text = "F";

    select1.add(option1);
    select1.add(option2);
    select1.add(option3);
    select1.add(option4);
    select1.add(option5);
    select1.add(option6);
    select1.add(option7);
    select1.add(option8);
    select1.add(option9);
    select1.add(option10);
    select1.add(option11);
    select1.add(option12);


    cell1.contentEditable = "true";
    cell2.contentEditable = "true";
    cell3.contentEditable = "true";
    cell4.contentEditable = "true";
    cell5.appendChild(select);
    cell6.appendChild(select1);
}
function deleteCourse11() {
    var table = document.getElementById("Additional-list").deleteRow(0-1);
}
/*------------------------------------------------------------------------------*/

/*Interactive Computing rows*/

function addCourse12() {
    var table = document.getElementById("5A-list");
    var row = table.insertRow(table.rows.length);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3); 
    var cell5 = row.insertCell(4);
    var cell6 = row.insertCell(5);

    var select = document.createElement("select");
    var option1 = document.createElement("option");
    var option2 = document.createElement("option");
    var option3 = document.createElement("option");
    option1.text = "Select";
    option2.text = "Yes";
    option3.text = "No";
    select.add(option1);
    select.add(option2);
    select.add(option3);


   
    var select1 = document.createElement("select");
    var option1 = document.createElement("option");
    var option2 = document.createElement("option");
    var option3 = document.createElement("option");
    var option4 = document.createElement("option");
    var option5 = document.createElement("option");
    var option6 = document.createElement("option");
    var option7 = document.createElement("option");
    var option8 = document.createElement("option");
    var option9 = document.createElement("option");
    var option10 = document.createElement("option");
    var option11 = document.createElement("option");
    var option12 = document.createElement("option");

    option1.text = "Select";
    option2.text = "A";
    option3.text = "A-";
    option4.text = "A+";
    option5.text = "B";
    option6.text = "B-";
    option7.text = "B+";
    option8.text = "C";
    option9.text = "C-";
    option10.text = "C+";
    option11.text = "D";
    option12.text = "F";

    select1.add(option1);
    select1.add(option2);
    select1.add(option3);
    select1.add(option4);
    select1.add(option5);
    select1.add(option6);
    select1.add(option7);
    select1.add(option8);
    select1.add(option9);
    select1.add(option10);
    select1.add(option11);
    select1.add(option12);


    cell1.contentEditable = "true";
    cell2.contentEditable = "true";
    cell3.contentEditable = "true";
    cell4.contentEditable = "true";
    cell5.appendChild(select);
    cell6.appendChild(select1);

    
}
function deleteCourse12() {
    var table = document.getElementById("5A-list").deleteRow(0-1);
}


function addCourse13() {
    var table = document.getElementById("Additional-lists");
    var row = table.insertRow(table.rows.length);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);
    var cell6 = row.insertCell(5);
    
    var select = document.createElement("select");
    var option1 = document.createElement("option");
    var option2 = document.createElement("option");
    var option3 = document.createElement("option");
    option1.text = "Select";
    option2.text = "Yes";
    option3.text = "No";
    select.add(option1);
    select.add(option2);
    select.add(option3);


   
    var select1 = document.createElement("select");
    var option1 = document.createElement("option");
    var option2 = document.createElement("option");
    var option3 = document.createElement("option");
    var option4 = document.createElement("option");
    var option5 = document.createElement("option");
    var option6 = document.createElement("option");
    var option7 = document.createElement("option");
    var option8 = document.createElement("option");
    var option9 = document.createElement("option");
    var option10 = document.createElement("option");
    var option11 = document.createElement("option");
    var option12 = document.createElement("option");

    option1.text = "Select";
    option2.text = "A";
    option3.text = "A-";
    option4.text = "A+";
    option5.text = "B";
    option6.text = "B-";
    option7.text = "B+";
    option8.text = "C";
    option9.text = "C-";
    option10.text = "C+";
    option11.text = "D";
    option12.text = "F";

    select1.add(option1);
    select1.add(option2);
    select1.add(option3);
    select1.add(option4);
    select1.add(option5);
    select1.add(option6);
    select1.add(option7);
    select1.add(option8);
    select1.add(option9);
    select1.add(option10);
    select1.add(option11);
    select1.add(option12);


    cell1.contentEditable = "true";
    cell2.contentEditable = "true";
    cell3.contentEditable = "true";
    cell4.contentEditable = "true";
    cell5.appendChild(select);
    cell6.appendChild(select1);
}
function deleteCourse13() {
    var table = document.getElementById("Additional-lists").deleteRow(0-1);
}



/* Traditional CS */
function addCourse14() {
    var table = document.getElementById("2of3");
    var row = table.insertRow(table.rows.length);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);
    var cell6 = row.insertCell(5);
    
    var select = document.createElement("select");
    var option1 = document.createElement("option");
    var option2 = document.createElement("option");
    var option3 = document.createElement("option");
    option1.text = "Select";
    option2.text = "Yes";
    option3.text = "No";
    select.add(option1);
    select.add(option2);
    select.add(option3);


   
    var select1 = document.createElement("select");
    var option1 = document.createElement("option");
    var option2 = document.createElement("option");
    var option3 = document.createElement("option");
    var option4 = document.createElement("option");
    var option5 = document.createElement("option");
    var option6 = document.createElement("option");
    var option7 = document.createElement("option");
    var option8 = document.createElement("option");
    var option9 = document.createElement("option");
    var option10 = document.createElement("option");
    var option11 = document.createElement("option");
    var option12 = document.createElement("option");

    option1.text = "Select";
    option2.text = "A";
    option3.text = "A-";
    option4.text = "A+";
    option5.text = "B";
    option6.text = "B-";
    option7.text = "B+";
    option8.text = "C";
    option9.text = "C-";
    option10.text = "C+";
    option11.text = "D";
    option12.text = "F";

    select1.add(option1);
    select1.add(option2);
    select1.add(option3);
    select1.add(option4);
    select1.add(option5);
    select1.add(option6);
    select1.add(option7);
    select1.add(option8);
    select1.add(option9);
    select1.add(option10);
    select1.add(option11);
    select1.add(option12);


    cell1.contentEditable = "true";
    cell2.contentEditable = "true";
    cell3.contentEditable = "true";
    cell4.contentEditable = "true";
    cell5.appendChild(select);
    cell6.appendChild(select1);
}
function deleteCourse14() {
    var table = document.getElementById("2of3").deleteRow(0-1);
}
















/*MiniMe button function*/

/*Minime for Intelligent System*/
const printButton = document.getElementById("print-btn");
printButton.addEventListener("click", function() {
	const fileUrl = "Intelligent_SystemDP.html";
	const printWindow = window.open(fileUrl, "", "height=600,width=800");
	printWindow.print();
});

function printFile() {
    var printWindow = window.open('Intelligent_SystemDP.html', 'Print1', 'height=400,width=600');
    printWindow.print();
  }


  /*Minime for Cyber Security*/
  printButton.addEventListener("click", function() {
      const fileUrl = "Cyber_SecurityDP.html";
      const printWindow = window.open(fileUrl, "", "height=600,width=800");
      printWindow.print();
  });
  
  function printFile1() {
      var printWindow = window.open('Cyber_SecurityDP.html', 'Print1', 'height=400,width=600');
      printWindow.print();
    }
  
/*Minime for Data Science*/
printButton.addEventListener("click", function() {
    const fileUrl = "Data_ScienceDP.html";
    const printWindow = window.open(fileUrl, "", "height=600,width=800");
    printWindow.print();
});

function printFile2() {
    var printWindow = window.open('Data_ScienceDP.html', 'Print1', 'height=400,width=600');
    printWindow.print();
  }


/*Minime for Interactive Computing*/
printButton.addEventListener("click", function() {
    const fileUrl = "Interactive_ComputingDP.html";
    const printWindow = window.open(fileUrl, "", "height=600,width=800");
    printWindow.print();
});

function printFile3() {
    var printWindow = window.open('Interactive_ComputingDP.html', 'Print1', 'height=400,width=600');
    printWindow.print();
  }

  /*Minime for Software Engineering*/
  printButton.addEventListener("click", function() {
      const fileUrl = "Software_EngineeringDP.html";
      const printWindow = window.open(fileUrl, "", "height=600,width=800");
      printWindow.print();
  });

  function printFile44() {
      var printWindow = window.open('Software_EngineeringDP.html', 'Print1', 'height=400,width=600');
      printWindow.print();
    }


/*Minime for Networks and Telecommunication*/
printButton.addEventListener("click", function() {
    const fileUrl = "Networks_and_TelecommunicationDP.html";
    const printWindow = window.open(fileUrl, "", "height=600,width=800");
    printWindow.print();
});

function printFile44() {
    var printWindow = window.open('Networks_and_TelecommunicationDP.html', 'Print1', 'height=400,width=600');
    printWindow.print();
  }

/*Minime for Traditional Computer Science*/
printButton.addEventListener("click", function() {
    const fileUrl = "Traditional_Computer_ScienceDP.html";
    const printWindow = window.open(fileUrl, "", "height=600,width=800");
    printWindow.print();
});

function printFile4() {
    var printWindow = window.open('Traditional_Computer_ScienceDP.html', 'Print1', 'height=400,width=600');
    printWindow.print();
  }


/*Minime for AuditCYBERS*/
printButton.addEventListener("click", function() {
    const fileUrl = "audit_report.html";
    const printWindow = window.open(fileUrl, "", "height=600,width=800");
    printWindow.print();
});

function printFile5() {
    var printWindow = window.open('audit_report.html', 'Print2', 'height=400,width=600');
    printWindow.print();
  }


  /*Minime for AuditINTELL_SY*/
printButton.addEventListener("click", function() {
    const fileUrl = "audit_report.html";
    const printWindow = window.open(fileUrl, "", "height=600,width=800");
    printWindow.print();
});

function printFile6() {
    var printWindow = window.open('audit_report.html', 'Print2', 'height=400,width=600');
    printWindow.print();
  }


 /*Minime for AuditDataSC*/
 printButton.addEventListener("click", function() {
    const fileUrl = "audit_report.html";
    const printWindow = window.open(fileUrl, "", "height=600,width=800");
    printWindow.print();
});

function printFile7() {
    var printWindow = window.open('audit_report.html', 'Print2', 'height=400,width=600');
    printWindow.print();
  }


/*Minime for AuditInteraCom*/
printButton.addEventListener("click", function() {
    const fileUrl = "audit_report.html";
    const printWindow = window.open(fileUrl, "", "height=600,width=800");
    printWindow.print();
});

function printFile8() {
    var printWindow = window.open('audit_report.html', 'Print2', 'height=400,width=600');
    printWindow.print();
  }


/*Minime for AuditNETWORK&TEL*/
printButton.addEventListener("click", function() {
    const fileUrl = "audit_report.html";
    const printWindow = window.open(fileUrl, "", "height=600,width=800");
    printWindow.print();
});

function printFile9() {
    var printWindow = window.open('audit_report.html', 'Print2', 'height=400,width=600');
    printWindow.print();
  }

/*Minime for AuditSoftEng*/
printButton.addEventListener("click", function() {
    const fileUrl = "audit_report.html";
    const printWindow = window.open(fileUrl, "", "height=600,width=800");
    printWindow.print();
});

function printFile8() {
    var printWindow = window.open('audit_report.html', 'Print2', 'height=400,width=600');
    printWindow.print();
  }

/*Minime for AuditTradi*/
printButton.addEventListener("click", function() {
    const fileUrl = "audit_report.html";
    const printWindow = window.open(fileUrl, "", "height=600,width=800");
    printWindow.print();
});

function printFile10() {
    var printWindow = window.open('audit_report.html', 'Print2', 'height=400,width=600');
    printWindow.print();
  }






  /*Print button function*/
function printCopy() {
    window.print();
  }





