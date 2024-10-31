document.addEventListener('DOMContentLoaded', function() {
    // Efecto de desplazamiento suave al hacer clic en enlaces de navegación
    document.querySelectorAll('a[href^="#"]').forEach(anchor => {
        anchor.addEventListener('click', function (e) {
            e.preventDefault();
            document.querySelector(this.getAttribute('href')).scrollIntoView({
                behavior: 'smooth'
            });
        });
    });

    // Evento de clic para mostrar un mensaje en la galería
    const galleryImages = document.querySelectorAll('.gallery img');
    galleryImages.forEach(image => {
        image.addEventListener('click', function() {
            alert('¡Has hecho clic en una imagen de la galería!');
        });
    });

    const fogTop = document.createElement('div');
    fogTop.className = 'fog fog-top';
    document.body.appendChild(fogTop);

    const fogBottom = document.createElement('div');
    fogBottom.className = 'fog fog-bottom';
    document.body.appendChild(fogBottom);

    setTimeout(() => {
        fogTop.classList.add('hidden');
        fogBottom.classList.add('hidden');
        document.body.style.overflow = 'auto'; // Permite el desplazamiento después de que la niebla se despeje
    }, 3000); // 3 segundos antes de que la niebla se despeje
});