$(document).ready(function () {
    $("[name='minus']").click(function () {
        var ingredient = $(this).attr("value");
        var counter = parseInt($("#counter-" + ingredient).val());
        if (counter > 0) {
            $("#counter-" + ingredient).val(counter - 1);
        }
        weblanches.updateValue();
    });

    $("[name='plus']").click(function () {
        var ingredient = $(this).attr("value");
        var counterIdentifier = "#counter-" + ingredient;
        var counter = parseInt($(counterIdentifier).val());
        $(counterIdentifier).val(counter + 1);
        weblanches.updateValue();
    });
});

var weblanches = function () {
    return {
        updateValue: function () {
            var ingredients = {};
            $("[id*='counter-']").each(function (index, item) {
                ingredients[$(item).attr("ingredient-type")] = parseInt($(item).val());
            });


            $.ajax({
                beforeSend: function (xhrObj) {
                    xhrObj.setRequestHeader("Content-Type", "application/json");
                    xhrObj.setRequestHeader("Accept", "application/json");
                },
                type: "POST",
                url: "/customSandwich/calculatePrice",
                data: JSON.stringify(ingredients),
                dataType: "json",
                success: function (response) {
                    $("#result").text(response.formattedPrice);
                }
            });

        }
    };
}();