const arrows = document.querySelectorAll('.arrow')
const sidebar = document.querySelector('.sidebar')
const sidebarBtn = document.querySelector('.home-content .icon')

document.addEventListener('DOMContentLoaded', () => {
	const links = document.querySelectorAll('a[data-page]');
	const contentArea = document.querySelector('.home-section');

	links.forEach(link => {
		link.addEventListener('click', event => {
			event.preventDefault(); 
			const page = link.getAttribute('data-page');

			
			fetch(page)
				.then(response => {
					if (!response.ok) {
						throw new Error('Erro ao carregar a página: ' + response.statusText);
					}
					return response.text();
				})
				.then(html => {
					contentArea.innerHTML = html;
				})
				.catch(error => {
					console.error(error);
					contentArea.innerHTML = '<h1>Erro ao carregar a página.</h1>';
				});
		});
	});
});


arrows.forEach(arrow =>
	arrow.addEventListener('click', event => {
		const arrowParent = event.target.parentElement.parentElement

		arrowParent.classList.toggle('show-menu')
	})
)

sidebarBtn.addEventListener('click', () => {
	sidebar.classList.toggle('close')
})

