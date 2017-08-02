$(document).ready(function(){

    $('#tryIt').click(function(){
        location.href = 'weeklyPlan.html';
    });

    $('#signup').click(function(){
        location.href = '/signup.html';
    });

    $('#login').click(function(){
        location.href = '/login.html';
    });

    $('#loginForm #submit').click(function(){
        location.href = 'weeklyPlan.html';
    });

    $('#signupForm #submit').click(function(){
        location.href = 'weeklyPlan.html';
    });

});

function CookingJob(recipeID, recipeName){
    this.recipeName = recipeName;
	this.cookingJob = {
			recipeID: recipeID,
			monday: [],
			tuesday: [],
			wednesday: [],
			thursday: [],
			friday: [],
			saturday: [],
			sunday: []
		} ;

	this.addSchedule = function(scheduleDay, mealEvent){
		this.cookingJob[scheduleDay].push(mealEvent);
	};

	this.postCookingJob = function(){
        $.ajax({
            url: "/api/cookingJob",
            method: "POST",
            data: JSON.stringify(this.cookingJob),
            dataType: "json",
            contentType: "application/json"
            }).done(function(msg){
        });
	};
}

function MealPlan() {
	this.createCookingJob = function(recipeID, recipeName){
		return new CookingJob(recipeID, recipeName);
	};
    
    this.findRecipeNameForID = function(recipeID){
        return "Not Yet Implemented";
    };
    
    this.loadCookingJobs = function(){
        var mealPlan = this;
        
        $.ajax({
            url: "/api/cookingJob",
            method: "GET",
            contentType: "application/json",
            context: self
            }).done(function(msg){
                msg.forEach(function(item){
                    var recipeID = item[recipeID];
                    var recipeName = "Not Yet Implemented";
                    var cookingJob = new CookingJob(recipeID, recipeName);
                    
                    var days = [ 'monday', 'tuesday', 'wednesday', 'thursday', 'friday', 'saturday', 'sunday' ] ;
                    days.forEach(function(day){
                        mealPlan.addToWeeklyPlan(cookingJob, day, item['schedule'][day]);
                    });
                });
        });
        
    };
    
    this.addToWeeklyPlan = function(cookingJob, scheduleDay, mealEvent){
        cookingJob.addSchedule(scheduleDay, mealEvent);
		var targetObject = $('#week').find('#' + scheduleDay).find('#' + mealEvent);
		$("<li recipeID='" + cookingJob.recipeID + "'>" + cookingJob.recipeName + "</li>").appendTo(targetObject);
    };
}
