function filterBooks() {

    let searchQuery = document.getElementById('searchBar').value.toLowerCase();
    let bookCards = document.getElementsByClassName('book-card');
    
    for (let i = 0; i < bookCards.length; i++) {
        let title = bookCards[i].getElementsByClassName('book-title')[0].innerText.toLowerCase();

        if (title.includes(searchQuery)) {
            bookCards[i].style.display = 'block';
        } else {
            bookCards[i].style.display = 'none';
        }
    }
}
