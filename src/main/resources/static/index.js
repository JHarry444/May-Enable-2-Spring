'use strict';

const output = document.getElementById('output');

document.getElementById('dinoForm').addEventListener("submit", function (event) {
    event.preventDefault();

    const form = event.target;

    const dino = {
        name: form.dinoName.value,
        age: form.dinoAge.value,
        species: form.dinoSpecies.value,
    }

    axios.post("/createDino", dino)
        .then(res => {
            console.log("RESPONSE: ", res);
            form.dinoName.focus();
            form.reset();
            renderDinos();
        })
        .catch(err => console.error(err));

    console.log("dino: ", dino);
});

function renderDinos() {
    axios.get("/getDinos")
        .then(res => {
            console.log("dinoS: ", res.data);
            output.innerHTML = "";
            for (let dino of res.data) {
                const dinoCol = document.createElement("div");
                dinoCol.className = "col";

                const dinoCard = document.createElement("div");
                dinoCard.className = "card";
                dinoCol.appendChild(dinoCard);

                const dinoDiv = document.createElement("div");
                dinoDiv.className = "card-body";
                dinoCard.appendChild(dinoDiv);

                const dinoName = document.createElement("h2");
                dinoName.innerText = dino.name;
                dinoDiv.appendChild(dinoName);

                const dinoAge = document.createElement("p");
                dinoAge.innerText = dino.age + " years old.";
                dinoDiv.appendChild(dinoAge);

                const dinoSpecies = document.createElement("p");
                dinoSpecies.innerText = dino.species;
                dinoSpecies.classList.add("btn", "btn-alert");
                dinoDiv.appendChild(dinoSpecies);

                const dinoDelete = document.createElement("button");
                dinoDelete.innerText = "DESTROY";
                dinoDelete.addEventListener("click", function () {
                    deleteDino(dino.id);
                });

                dinoDiv.appendChild(dinoDelete);

                output.appendChild(dinoCol);
            }
        })
        .catch(err => console.error(err));
}

function deleteDino(id) {
    axios.delete("/removeDino/" + id)
        .then(res => {
            console.log(res);
            renderDinos();
        })
        .catch(err => console.error(err));
}


renderDinos();