var app = new Vue({
        el: "#app",
        data: {
            companyList: [],
            company: {}
        },
        methods: {
            findAll() {
                axios.get("company").then(function (response) {
                    if (response.data.success == true) {
                        app.companyList = response.data.data;
                    } else {
                        alert(response.data.message);
                    }
                })
            },
            findOne(companyId) {
                axios.get("company/" + companyId).then(function (response) {
                    if (response.data.success == true) {
                        app.company = response.data.data;
                    } else {
                        alert(response.data.message);
                    }
                })
            },
            deleteOne(companyId) {
                axios.delete("company/"+companyId).then(function (response) {
                    if (response.data.success == true) {
                        app.findAll();
                    } else {
                        alert(response.data.message);
                    }
                })
            },
            save(){
                if (app.company.id == null || app.company.id.length < 1) {
                    axios.post("company",this.company).then(function (response) {
                        if (response.data.success == true) {
                            app.findAll();
                        } else {
                            alert(response.data.message);
                        }
                    });
                } else {
                    axios.put("company", this.company).then(function (response) {
                        if (response.data.success == true) {
                            app.findAll();
                        } else {
                            alert(response.data.message);
                        }
                    });
                }
            }
        },
        created() {
            this.findAll();
        }
    })
;