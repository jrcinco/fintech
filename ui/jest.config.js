module.exports = {
  verbose: true,
  moduleDirectories: ['node_modules', 'src', 'tests'],
  moduleFileExtensions: [
    'js',
    'jsx',
    'json',
    'vue',
  ],
  transform: {
    '^.+\\.vue$': 'vue-jest',
    '.+\\.(css|styl|less|sass|scss|png|jpg|ttf|woff|woff2)$': 'jest-transform-stub',
    '^.+\\.js?$': 'babel-jest',
  },
  moduleNameMapper: {
    '.+\\.(css|styl|less|sass|scss|svg|png|jpg|ttf|woff|woff2)$': 'jest-transform-stub',
    '^@/(.*)$': '<rootDir>/src/$1',
  },
  snapshotSerializers: [
    'jest-serializer-vue',
  ],
  testMatch: [
    '<rootDir>/(tests/unit/**/*.spec.(js|jsx|ts|tsx)|**/__tests__/*.(js|jsx|ts|tsx))',
  ],
  testURL: 'http://localhost/',
  setupTestFrameworkScriptFile: '<rootDir>/tests/unit/setupTest.js',
  setupFiles: ['<rootDir>/tests/unit/setup'],
  collectCoverage: true,
  coverageDirectory: '<rootDir>/tests/unit/coverage',
  collectCoverageFrom: [
    'src/**/*.{js,vue}',
    '!src/main.js',
    '!src/router.js',
    '!src/api/**',
    '!src/plugins/**',
    '!src/store/**',
    '!**/node_modules/**',
  ],
};
