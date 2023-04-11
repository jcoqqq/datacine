window.onload = function() {
    const boutonAfficher = document.querySelector("#bouton-afficher-commentaires");
    const divCommentaires = document.querySelector(".liste-commentaires");
    boutonAfficher.addEventListener("click", () => {
        if (divCommentaires.style.display === "none") {
            divCommentaires.style.display = "block";
            boutonAfficher.textContent = "Cacher les commentaires";
        } else {
            divCommentaires.style.display = "none";
            boutonAfficher.textContent = "Afficher les commentaires";
        }
    });
    const ratingInputs = document.querySelectorAll('input[type="radio"]');
    const noteValue = document.querySelector("#note-value");

    ratingInputs.forEach((input) => {
        input.addEventListener("change", () => {
            noteValue.textContent = input.value;
        });
    });
    const toggleButton = document.getElementById('toggle-comment');
    const commentForm = document.getElementById('comment-form');

    toggleButton.addEventListener('click', function () {
        if (commentForm.style.display === 'none') {
            commentForm.style.display = 'block';
            toggleButton.textContent = 'Masquer le formulaire';
        } else {
            commentForm.style.display = 'none';
            toggleButton.textContent = 'Écrire un commentaire';
        }
    });

};


