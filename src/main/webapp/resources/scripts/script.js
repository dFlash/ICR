var dataObject = {};
var map = {};
var isActive = false;

function bonusTypesMenuClicked() {
    if (isActive) {
        clearDiv();
        isActive = false;
    } else {
        bonusTypesRequest();
        isActive = true;
    }
}

function bonusTypesRequest() {
    map = {};
    dataObject = {};
    clearDiv();
    addLoader();
    $.getJSON("http://localhost:8080/icr/bonus-type", function (data) {
        $('#bonusTypeDiv').empty();
        $.each(data, function (index, value) {
            map[index] = value;
            var link = "<button class='btn btn-link' onclick='bonusTypeRequest("+ value.id +")' " +
                "' >" + value.type + "</button>";
            $('#bonusTypeDiv').append(link);
            var editButton = "<button class='btn btn-primary' onclick='editForm("+ index +")'>Edit</button>"
            $('#bonusTypeDiv').append(editButton);
            var deleteButton = "<button class='btn btn-danger' onclick='deleteBonusType("+ value.id +")'>Delete</button>"
            $('#bonusTypeDiv').append(deleteButton);
            $('#bonusTypeDiv').append("<br>");
        });
        var addButton = "<button class='btn btn-success' onclick='addForm()'>Add</button>"
        $('#bonusTypeDiv').append(addButton);

    });
}

function bonusTypeRequest(id) {
    clearDiv();
    addLoader();
    $.getJSON("http://localhost:8080/icr/bonus-type/"+id, function (data) {
        $('#bonusTypeDiv').empty();
        var desc = "<p>id = " + data.id + " type = " + data.type + "</p>";
        $('#bonusTypeDiv').append(desc);
        $('#bonusTypeDiv').append("<br>");
        var backBtn = "<button class='btn btn-default' onclick='bonusTypesRequest()'>Back</button>"
        $('#bonusTypeDiv').append(backBtn);
    });
}

function addForm() {
    dataObject = {};
    clearDiv();
    var label = "<p>Type name </p>";
    $('#bonusTypeDiv').append(label);
    var input = "<input placeholder='Bonus Type' onchange='onTypeChange(this.value)' />";
    $('#bonusTypeDiv').append(input);
    $('#bonusTypeDiv').append("<br>");
    var saveBtn = "<button class='btn btn-primary' onclick='addBonusType()'>Add</button>"
    $('#bonusTypeDiv').append(saveBtn);
    var backBtn = "<button class='btn btn-default' onclick='bonusTypesRequest()'>Back</button>"
    $('#bonusTypeDiv').append(backBtn);
}

function addBonusType() {
    if (!dataObject.type) {
        alert("Type can not be empty");
        return;
    }
    clearDiv();
    addLoader();
    $.ajax(
        {
            url: "http://localhost:8080/icr/bonus-type/",
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(dataObject),
            success: function() {
                bonusTypesRequest();
            }
        }
    );
}

function editForm(index) {
    dataObject = map[index];
    clearDiv();
    var label = "<p>Type name </p>";
    $('#bonusTypeDiv').append(label);
    var input = "<input value='" + dataObject.type + "' onchange='onTypeChange(this.value)' />";
    $('#bonusTypeDiv').append(input);
    $('#bonusTypeDiv').append("<br>");
    var saveBtn = "<button class='btn btn-primary' onclick='saveBonusType()'>Save</button>"
    $('#bonusTypeDiv').append(saveBtn);
    var backBtn = "<button class='btn btn-default' onclick='bonusTypesRequest()'>Back</button>"
    $('#bonusTypeDiv').append(backBtn);
}

function onTypeChange(newValue) {
    dataObject.type = newValue;
}

function saveBonusType() {
    if (!dataObject.type) {
        alert("Type can not be empty");
        return;
    }
    clearDiv();
    addLoader();
    $.ajax(
        {
            url: "http://localhost:8080/icr/bonus-type/",
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(dataObject),
            success: function() {
                bonusTypesRequest();
            }
        }
    );
}

function deleteBonusType(id) {
    var shouldBeDeleted = confirm("Are you sure?");
    if (shouldBeDeleted == false) {
        return;
    }
    clearDiv();
    addLoader();
    $.ajax(
        {
            url: "http://localhost:8080/icr/bonus-type/" + id,
            type: 'DELETE',
            success: function() {
                bonusTypesRequest();
            }
        }
    );
}

function clearDiv() {
    $('#bonusTypeDiv').empty();
}

function addLoader() {
    $('#bonusTypeDiv').append("<div class='loader'></div>");
}