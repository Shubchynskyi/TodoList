function editTask(id) {
    let editButton = document.getElementById('edit-' + id);
    let saveButton = document.getElementById('save-' + id);
    let descriptionSpan = document.getElementById('description-' + id);
    let inputDescription = document.getElementById('input-description-' + id);
    let statusSpan = document.getElementById('status-' + id);
    let selectStatus = document.getElementById('select-status-' + id);

    editButton.classList.add('hidden');
    saveButton.classList.remove('hidden');
    descriptionSpan.classList.add('hidden');
    inputDescription.classList.remove('hidden');
    statusSpan.classList.add('hidden');
    selectStatus.classList.remove('hidden');
}