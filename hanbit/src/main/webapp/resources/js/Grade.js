/**
 * Grade
 */
	var grade = {
		context : '',
		setContext : function(context) {
			this.context = context;
		},
		getContext : function() {
			return this.context;
		},
		init : function(context) {
			this.setContext(context);
			
		}
	};