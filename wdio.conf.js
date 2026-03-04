exports.config = {
    // ====================
    // Runner Configuration
    // ====================
    runner: 'local',
    port: 4723,

    // ==================
    // Specify Test Files
    // ==================
    specs: [
        './features/**/*.feature'
    ],
    exclude: [],

    // ============
    // Capabilities
    // ============
    maxInstances: 1,
    capabilities: [{
        platformName: "Android",
        "appium:deviceName": "Galaxy A16",
        "appium:automationName": "UiAutomator2",
        "appium:app": "D:\\descargas\\mda-2.0.2-23.apk",
        "appium:autoGrantPermissions": true,
        "appium:appWaitActivity": "*"
    }],

    // ===================
    // Test Configurations
    // ===================
    logLevel: 'info',
    bail: 0,
    baseUrl: '',
    waitforTimeout: 10000,
    connectionRetryTimeout: 120000,
    connectionRetryCount: 3,
    services: ['appium'],
    framework: 'cucumber',
    reporters: ['spec', ['allure', {
        outputDir: 'allure-results',
        disableWebdriverStepsReporting: true,
        disableWebdriverScreenshotsReporting: false,
    }]],

    // If you are using Cucumber you need to specify the location of your step definitions.
    cucumberOpts: {
        require: ['./features/step-definitions/steps.js'],
        backtrace: false,
        requireModule: [],
        dryRun: false,
        failFast: false,
        snippets: true,
        source: true,
        strict: false,
        tagExpression: '',
        timeout: 60000,
        ignoreUndefinedDefinitions: false
    },

    // =====
    // Hooks
    // =====
    afterStep: async function (step, scenario, result, context) {
        if (!result.passed) {
            await driver.takeScreenshot();
        }
    }
}
