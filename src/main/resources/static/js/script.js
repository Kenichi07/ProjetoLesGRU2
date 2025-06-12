function toggleDropdown() {
  document.getElementById("myDropdown").classList.toggle("show");
}

/* Fecha se clicar fora */
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {
    let dropdowns = document.getElementsByClassName("dropdown-content");
    for (let i = 0; i < dropdowns.length; i++) {
      let openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}

function selecionarCard(card) {
  // Se o card já estiver selecionado, desmarca
  if (card.classList.contains('selecionado')) {
    card.classList.remove('selecionado');
  } else {
    // Remove a seleção de outros cards
    document.querySelectorAll('.card').forEach(c => c.classList.remove('selecionado'));

    // Adiciona a seleção no card clicado
    card.classList.add('selecionado');
  }
}

function atualizarVisibilidade() {
  const profissional = document.getElementById('profissional').checked;
  const whatsappGroup = document.getElementById('whatsapp-group');

  if (profissional) {
    whatsappGroup.style.display = 'block';
  } else {
    whatsappGroup.style.display = 'none';
  }
}

function toggleFavorito(checkbox) {
  const cursoId = checkbox.getAttribute('data-id');
  const url = checkbox.checked
    ? `/curso/favoritar/${cursoId}`
    : `/curso/desfavoritar/${cursoId}`;

  fetch(url, { method: 'POST' })
    .then(res => {
      if (!res.ok) throw new Error('Erro ao atualizar favorito');
    })
    .catch(err => {
      alert(err.message);
      checkbox.checked = !checkbox.checked; // Reverte em caso de erro
    });
}

// Mostrar e esconder o filtro
const filterButton = document.getElementById('filterButton');
const filterDropdown = document.getElementById('filterDropdown');

filterButton.addEventListener('click', (event) => {
    event.stopPropagation(); // Impede o clique de propagar e fechar o menu imediatamente
    filterDropdown.classList.toggle('hidden');
});

// Fecha o dropdown ao clicar fora
document.addEventListener('click', (event) => {
    if (!filterDropdown.classList.contains('hidden')) {
        filterDropdown.classList.add('hidden');
    }
});



