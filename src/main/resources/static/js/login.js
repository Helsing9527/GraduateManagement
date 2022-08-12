$(function () {
    new Vue({
        el: "#app",
        data() {
            return {
                loginOrRegister: 'login',
                ruleForm: {
                    account: '',
                    password: '',
                    permission: ''
                },
                rules: {
                    account: [
                        {required: true, message: '请输入用户名', trigger: 'blur'}
                    ],
                    password: [
                        {required: true, message: '请输入密码', trigger: 'blur'}
                    ]
                }
            }
        },
        methods: {
            // 切换注册
            switchRegister() {
                this.loginOrRegister = 'register';
                this.resetForm('ruleForm');
            },
            // 切换登录
            switchLogin() {
                this.loginOrRegister = 'login';
                this.resetForm('ruleForm');
            },
            // 登录
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        axios.post("/user", this.ruleForm).then((res) => {
                            if (res.data.flag) {
                                this.$message.success(res.data.msg);
                                localStorage.setItem("userInfo", res.data.data);
                                window.location.href = '/success'
                            } else {
                                this.$message.error(res.data.msg);
                            }
                        })
                    } else {
                        this.$message.error('用户名 或 密码有误！');
                        return false;
                    }
                });
            },
            // 注册
            registerForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        axios.post("/user/register", this.ruleForm).then((res) => {
                            if (res.data.flag) {
                                this.$message.success(res.data.msg);
                                this.switchLogin();
                            } else {
                                this.$message.error(res.data.msg);
                            }
                        })
                    } else {
                        this.$message.error('请完善表单后再注册');
                        return false;
                    }
                });
            },
            // 重置表单
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    })
})