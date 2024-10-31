document.addEventListener('DOMContentLoaded', function() {
    // Efecto de desplazamiento suave al hacer clic en enlaces de navegación
    const links = document.querySelectorAll('a[href^="#"]');
    links.forEach(link => {
        link.addEventListener('click', function(e) {
            e.preventDefault();
            const targetId = this.getAttribute('href');
            const targetElement = document.querySelector(targetId);
            targetElement.scrollIntoView({ behavior: 'smooth' });
        });
    });

    // Evento de clic para mostrar un mensaje en la galería
    const galleryImages = document.querySelectorAll('.gallery img');
    galleryImages.forEach(image => {
        image.addEventListener('click', function() {
            alert('¡Has hecho clic en una imagen de la galería!');
        });
    });
});