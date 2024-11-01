// This file contains JavaScript code for animations on the webpage.

document.addEventListener("DOMContentLoaded", function() {
    const elements = document.querySelectorAll('.animate');

    elements.forEach(element => {
        element.style.opacity = 0;
        element.style.transform = 'translateY(20px)';
        
        setTimeout(() => {
            element.style.transition = 'opacity 0.5s ease, transform 0.5s ease';
            element.style.opacity = 1;
            element.style.transform = 'translateY(0)';
        }, 100);
    });
});

document.addEventListener('DOMContentLoaded', () => {
    const sections = document.querySelectorAll('section');
    sections.forEach(section => {
        section.style.opacity = 0;
        section.style.transition = 'opacity 1s ease-in-out';
    });

    const observer = new IntersectionObserver(entries => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.style.opacity = 1;
            }
        });
    }, {
        threshold: 0.1
    });

    sections.forEach(section => {
        observer.observe(section);
    });
});

document.addEventListener('DOMContentLoaded', () => {
    const gridItems = document.querySelectorAll('.grid-item');
    const overlay = document.getElementById('overlay');
    const overlayText = document.getElementById('overlay-text');
    const closeBtn = document.querySelector('.close-btn');

    gridItems.forEach(item => {
        item.addEventListener('click', () => {
            overlayText.innerHTML = item.innerHTML;
            overlay.style.display = 'flex';
        });
    });

    closeBtn.addEventListener('click', () => {
        overlay.style.display = 'none';
    });

    overlay.addEventListener('click', (e) => {
        if (e.target === overlay) {
            overlay.style.display = 'none';
        }
    });

    // Playground functionality
    const createArrayBtn = document.getElementById('create-array-btn');
    const arrayInput = document.getElementById('array-input');
    const arrayOutput = document.getElementById('array-output');

    createArrayBtn.addEventListener('click', () => {
        const input = arrayInput.value;
        const array = input.split(',').map(Number);
        arrayOutput.textContent = `Array creado: [${array.join(', ')}]`;
    });
});