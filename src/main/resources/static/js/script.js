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