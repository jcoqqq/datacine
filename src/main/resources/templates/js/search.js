var jsonData;

const searchInput = document.querySelector('#search-input');
const searchResults = document.querySelector('#search-results');
function httpGet(theUrl)
{
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", theUrl, false ); // false for synchronous request
    xmlHttp.send( null );
    return xmlHttp.responseText;
}

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

searchInput.addEventListener('input', async () => {
    let inputValue = searchInput.value.toLowerCase();
    if(inputValue.length==0){
        inputValue="null";
    }
    try {
        const response = await fetch(`/proxy/searchjs/${inputValue}`);
        const jsonData = await response.json();
        const results = jsonData.filter(data => data.value.toLowerCase().includes(inputValue));
        displayResults(results);
    } catch (error) {
        console.error(error);
    }
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
