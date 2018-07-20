本程序有很多模块的基本写法。
1：JOB。@EnableScheduling ，@Scheduled(fixedRate = 5000)
 添加了线程池后，多个任务就不是阻塞式。
    /**定时任务线程池
     * @return
     */
    @Bean(name = "CDMTask")
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);
        return taskScheduler;
    }
2：ActiveMq 的写法。含监听器、发送消息写法。
3：IBatis 样例
4：freemarker 样例
5：oracle 的调用。
6：多个配置文件时候的写法
7：打包发布的写法
8：运行的调用方法