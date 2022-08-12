$(function () {
    new Vue({
        el: "#app",
        data() {
            return {
                // 默认主页-毕业生基本信息
                activeIndex: '2',
                // 分页工具
                pagination: {
                    currentPage: 1,
                    pageSize: 10,
                    total: 0
                },
                // 毕业生基本信息列表
                basicInfo: [],
                // 毕业生基本信息创建弹窗
                createDialogVisible: false,
                // 毕业生基本信息编辑弹窗
                editDialogVisible: false,
                // 基本信息表单
                basicForm: {
                    name: '',
                    gender: '',
                    nation: '',
                    hometown: '',
                    graduationTime: '',
                    grade: '',
                    discipline: '',
                    politicalStatus: ''
                },
                basicRules: {
                    name: [
                        { required: true, message: '请输入姓名', trigger: 'blur' }
                    ],
                    gender: [
                        { required: true, message: '请选择性别', trigger: 'change' }
                    ],
                    nation: [
                        { required: true, message: '请输入民族', trigger: 'blur' }
                    ],
                    hometown: [
                        { required: true, message: '请输入籍贯', trigger: 'blur' }
                    ],
                    graduationTime: [
                        { required: true, message: '请选择日期', trigger: 'change' }
                    ],
                    grade: [
                        { required: true, message: '请输入年级', trigger: 'blur' }
                    ],
                    discipline: [
                        { required: true, message: '请输入专业', trigger: 'blur' }
                    ],
                    politicalStatus: [
                        { required: true, message: '请选择政治面貌', trigger: 'change' }
                    ],
                },

                // 毕业生就业信息列表
                empInfo: [],
                // 毕业生就业信息创建弹窗
                createEmpDialogVisible: false,
                // 就业信息表单
                empForm: {
                    bid: '',
                    name: '',
                    empTime: '',
                    employer: '',
                    natureOfWork: '',
                    post: '',
                    address: ''
                },
                empRules: {
                    empTime: [
                        { required: true, message: '请选择日期', trigger: 'change' }
                    ],
                    employer: [
                        { required: true, message: '工作单位', trigger: 'blur' }
                    ],
                    natureOfWork: [
                        { required: true, message: '工作性质', trigger: 'blur' }
                    ],
                    post: [
                        { required: true, message: '职务', trigger: 'blur' }
                    ],
                    address: [
                        { required: true, message: '地址', trigger: 'blur' }
                    ]
                }
            }
        },
        methods: {
            handleSelect(key) {
                if (key != null) {
                    this.activeIndex = key;
                    if (key == '1') {
                        this.queryBasic();
                    }
                    if (key == '2') {
                        this.queryEmp();
                    }
                } else {
                    this.activeIndex = '1';
                    this.queryBasic();
                }
            },
            handleSizeChange(val) {
                this.pagination.pageSize = val;
                this.queryBasic();
            },
            handleCurrentChange(val) {
                this.pagination.currentPage = val;
                this.queryBasic();
            },
            // 查询 毕业生基本信息
            queryBasic() {
                param = "?name=" + this.basicForm.name;
                param += "&grade=" +this.basicForm.grade;
                axios.get("/api/basic/" + this.pagination.currentPage + "/" + this.pagination.pageSize + param).then((res) => {
                    if (res.data.flag) {
                        this.basicInfo = res.data.data.records;
                        this.pagination.currentPage = res.data.data.current;
                        this.pagination.pageSize = res.data.data.size;
                        this.pagination.total = res.data.data.total;
                    }
                })
            },
            editBasicInfo(row) {
                this.editDialogVisible = true;
                this.basicForm = row;
            },
            // 新增毕业生基本信息
            createBasicInfo() {
                axios.post("/api/basic", this.basicForm).then((res) => {
                    if (res.data.flag) {
                        this.$notify({
                            title: '成功',
                            message: res.data.msg,
                            type: 'success'
                        });
                        this.resetForm('basicForm')
                        this.createDialogVisible = false;
                    } else {
                        this.$notify.error({
                            title: '错误',
                            message: res.data.msg
                        });
                    }
                }).finally(() => {
                    this.queryBasic()
                })
            },
            // 提交修改毕业生基本信息
            putEditBasicInfo() {
                axios.put("/api/basic", this.basicForm).then((res) => {
                    if (res.data.flag) {
                        this.$notify({
                            title: '成功',
                            message: res.data.msg,
                            type: 'success'
                        });
                        this.editDialogVisible = false;
                    } else {
                        this.$notify.error({
                            title: '错误',
                            message: res.data.msg
                        });
                    }
                }).finally(() => {
                    this.resetForm('basicForm')
                    this.queryBasic()
                })
            },
            deleteBasic(row) {
                axios.delete("/api/basic/0" + row.id).then((res) => {
                    if (res.data.flag) {
                        this.$notify({
                            title: '成功',
                            message: res.data.msg,
                            type: 'success'
                        })
                    } else {
                        this.$notify.error({
                            title: '错误',
                            message: res.data.msg
                        })
                    }
                }).finally(() => {
                    this.queryBasic()
                })
            },

            // 毕业生就业信息
            // 查询 毕业生基本信息
            queryEmp() {
                param = "?empTime=" + this.empForm.empTime;
                param += "&employer=" +this.empForm.employer;
                axios.get("/api/emp/" + this.pagination.currentPage + "/" + this.pagination.pageSize + param).then((res) => {
                    if (res.data.flag) {
                        this.empInfo = res.data.data.records;
                        this.pagination.currentPage = res.data.data.current;
                        this.pagination.pageSize = res.data.data.size;
                        this.pagination.total = res.data.data.total;
                    }
                })
            },
            // 新增毕业生基本信息
            createEmpInfo() {
                console.log(this.empForm)
                axios.post("/api/emp", this.empForm).then((res) => {
                    if (res.data.flag) {
                        this.$notify({
                            title: '成功',
                            message: res.data.msg,
                            type: 'success'
                        });
                        this.resetForm('empForm')
                        this.createEmpDialogVisible = false;
                    } else {
                        this.$notify.error({
                            title: '错误',
                            message: res.data.msg
                        });
                    }
                }).finally(() => {
                    this.queryEmp()
                })
            },
            // 重置表单
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        },
        mounted() {
            this.queryBasic();
        }
    })
})