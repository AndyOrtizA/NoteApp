let noteTitle = document.getElementById("noteTitle");
let noteContent = document.getElementById("content");

let saveBtn = document.getElementById("saveBtn");
let notesList = document.getElementById("notesList");

let btnClearAll = document.getElementById("btnClear");

let notes = new Array();

function fetchGetNotes() {
    const requestOptions = {
        method: "GET",
        redirect: "follow"
    };

    fetch("http://localhost:8088/api/notes/", requestOptions)
        .then((response) => response.json())
        .then((result) => {
            notes=result;
            printNotes();
        })
        .catch((error) => console.error(error));
}//fetchProductos

function deleteNote(id) {

    const requestOptions = {
        method: "DELETE",
        redirect: "follow"
    };

    let http = `http://localhost:8088/api/notes/${id}`;

    fetch(http, requestOptions)
        .then((response) => response.text())
        .then((result) => {
			console.log(result)
        	fetchGetNotes();
		})
        .catch((error) => console.error(error));

    
} //deleteNote

function printNotes() {
    notesList.innerHTML = "";
    notes.forEach(element => {
        let row = `<tr> 
        <td>${element.id}</td>
        <td>${element.title}</td>
        <td>${element.content}</td>
        <td>
            <button class="btn btn-danger btn-sm" onclick="deleteNote(${element.id})">Delete</button>
        </td>
    </tr>`;
        notesList.insertAdjacentHTML("beforeend", row)
    });
} //printNotes

saveBtn.addEventListener("click", function (event) {
    event.preventDefault();
    let titleN = noteTitle.value.trim();
    let contentN = noteContent.value.trim();

    if (titleN && contentN) {
        const myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");

        let note = {
            "title": titleN,
            "content": contentN
        };


        const raw = JSON.stringify(note);

        const requestOptions = {
            method: "POST",
            headers: myHeaders,
            body: raw,
            redirect: "follow"
        };

        fetch("http://localhost:8088/api/notes/", requestOptions)
            .then((response) => response.text())
            .then((result) => {
				console.log(result)
				fetchGetNotes();
            })
            .catch((error) => console.error(error));


        

        noteTitle.value = "";
        noteContent.value = "";
        noteTitle.focus();
    }
    else {
        noteTitle.focus();
    }
})//saveBtn

btnClearAll.addEventListener("click", function (event) {
    event.preventDefault();
    const requestOptions = {
        method: "DELETE",
        redirect: "follow"
    };

    fetch("http://localhost:8088/api/notes/", requestOptions)
        .then((response) => response.text())
        .then((result) => console.log(result))
        .catch((error) => console.error(error));

    notes = new Array();
    notesList.innerHTML = "";
    noteTitle.value = "";
    noteContent.value = "";
})//btnClearAll

window.addEventListener("load", function (event) {
    event.preventDefault();
    fetchGetNotes();
})