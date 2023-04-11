const jsonData = [
    {
        "index": "/film/1",
        "value": "Première valeur"
    },
    {
        "index": "/film/2",
        "value": "Deuxième valeur"
    },
    {
        "index": "/film/3",
        "value": "Troisieme valeur"
    },
    {
        "index": "/film/4",
        "value": "Quatrieme valeur"
    },
    {
        "index": "/film/5",
        "value": "Cinquième valeur"
    },
    {
        "index": "/film/6",
        "value": "Sixième valeur"
    }
];

const searchInput = document.querySelector('#search-input');
const searchResults = document.querySelector('#search-results');

function displayResults(results) {
    searchResults.innerHTML = '';
    if (results.length > 0) {
        for (let i = 0; i < results.length; i++) {
            const li = document.createElement('li');
            const link = document.createElement('a');
            link.textContent = results[i].value;
            link.href = `${results[i].index}`;
            li.setAttribute('data-index', results[i].index);
            link.setAttribute('data-index', results[i].index);
            li.appendChild(link);
            searchResults.appendChild(li);
        }
        searchResults.style.display = 'block';
        const firstThreeResults = document.querySelectorAll('#search-results li:nth-child(-n+3)');
        firstThreeResults.forEach(result => result.classList.add('active'));
    } else {
        searchResults.style.display = 'none';
    }
}

searchInput.addEventListener('input', () => {
    const inputValue = searchInput.value.toLowerCase();
    //c'est là ou il faudra faire requete quete et changer le json dynamiquement et si rien tu envoyes un json vide
    const results = jsonData.filter(data => data.value.toLowerCase().includes(inputValue));
    displayResults(results);
});

searchInput.addEventListener('blur', () => {
    setTimeout(() => {
        searchResults.style.display = 'none';
    }, 200);
});

searchResults.addEventListener('mouseover', (event) => {
    const hoveredResult = event.target.closest('li');
    if (hoveredResult) {
        searchResults.querySelectorAll('li').forEach(li => li.classList.remove('active'));
        hoveredResult.classList.add('active');
        const activeResults = searchResults.querySelectorAll('li.active');
        if (activeResults.length > 3) {
            activeResults[0].classList.remove('active');
        }
    }
});

searchResults.addEventListener('mouseleave', () => {
    const activeResults = searchResults.querySelectorAll('li.active');
    activeResults.forEach(result => result.classList.remove('active'));
    const firstThreeResults = document.querySelectorAll('#search-results li:nth-child(-n+3)');
    firstThreeResults.forEach(result => result.classList.add('active'));
});
