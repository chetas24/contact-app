document.getElementById('singleContactForm').onsubmit = async function(e) {
    e.preventDefault();
    const form = e.target;
    const data = {
        name: form.name.value,
        phoneNum: form.phoneNum.value,
        birthday: form.birthday.value
    };
    try {
        const response = await fetch('http://localhost:8081/contacts', {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(data)
        });
        if (!response.ok) {
            throw new Error('Failed to save contact');
        }
        const result = await response.json();
        document.getElementById('singleResult').innerText = result.message || 'Contact saved successfully!';
    } catch (err) {
        document.getElementById('singleResult').innerText = 'Error: ' + err.message;
    }
};